# Module A: Backend Engineering - C++ Track (Developers 2 & 3)

## 📖 Overview
Advanced backend development using C++ with modern frameworks (Beast/Asio, gRPC) for high-performance ShopFlow e-commerce platform backend.

**Duration**: 30 days
**Time Commitment**: 6.5 hours/day per developer
**Prerequisites**: Module 0 Foundations completion
**Focus**: System design, performance, concurrency, microservices architecture

---

## 🎯 Module Learning Outcomes

By end of Module A (C++), you will be able to:
- Design high-performance REST APIs in C++
- Implement asynchronous I/O with Asio/Beast
- Build RESTful web services with Beast
- Manage memory efficiently in production systems
- Implement concurrent request handling
- Build microservices with gRPC
- Optimize for performance and latency
- Implement proper error handling & logging
- Deploy C++ backend applications
- Build scalable distributed systems

---

## 🛠️ Technology Stack

- **Language**: C++17/20
- **Web Framework**: Beast/Asio (for REST APIs)
- **RPC Framework**: gRPC (for microservices)
- **Build System**: CMake
- **Database**: MySQL (with connector-c++)
- **Testing**: Catch2, Google Test
- **Performance Tools**: Valgrind, perf, wrk

---

## 📅 Weekly Breakdown

### Week 1: C++ Fundamentals & Modern C++ Features

#### Day 1-2: C++17/20 Features & Memory Management
**Learning Objectives**:
- Smart pointers (unique_ptr, shared_ptr)
- RAII principles
- Modern C++ features (auto, lambdas, ranges)
- Memory safety and avoiding leaks

**Code Examples**:
```cpp
// Header file: Product.hpp
#pragma once
#include <string>
#include <memory>
#include <vector>
#include <decimal>
#include <chrono>

class Category;

class Product {
private:
    long id_;
    std::string name_;
    std::string description_;
    double price_;
    int stock_quantity_;
    std::shared_ptr<Category> category_;
    std::chrono::system_clock::time_point created_at_;
    
public:
    // Constructor
    Product(const std::string& name, double price, 
            std::shared_ptr<Category> category);
    
    // Getters
    long getId() const { return id_; }
    const std::string& getName() const { return name_; }
    double getPrice() const { return price_; }
    int getStockQuantity() const { return stock_quantity_; }
    std::shared_ptr<Category> getCategory() const { return category_; }
    
    // Setters
    void setName(const std::string& name) { name_ = name; }
    void setPrice(double price) { 
        if (price < 0) throw std::invalid_argument("Price cannot be negative");
        price_ = price;
    }
    
    // Methods
    double calculateDiscount(double rate) const;
    bool decrementStock(int quantity);
};

// Implementation
#include "Product.hpp"
#include <iostream>

Product::Product(const std::string& name, double price,
                std::shared_ptr<Category> category)
    : id_(0), name_(name), price_(price), stock_quantity_(0),
      category_(category), created_at_(std::chrono::system_clock::now()) {
    if (name.empty()) {
        throw std::invalid_argument("Product name cannot be empty");
    }
    if (price < 0) {
        throw std::invalid_argument("Price cannot be negative");
    }
}

double Product::calculateDiscount(double rate) const {
    if (rate < 0 || rate > 1) {
        throw std::invalid_argument("Discount rate must be between 0 and 1");
    }
    return price_ * rate;
}

bool Product::decrementStock(int quantity) {
    if (quantity < 0) return false;
    if (stock_quantity_ < quantity) return false;
    
    stock_quantity_ -= quantity;
    return true;
}
```

**Smart Pointers Best Practices**:
```cpp
// Good: Using unique_ptr for exclusive ownership
std::unique_ptr<Product> createProduct(const std::string& name, double price) {
    return std::make_unique<Product>(name, price, nullptr);
}

// Good: Using shared_ptr for shared ownership
void addToCart(std::shared_ptr<Product> product) {
    cart_.push_back(product);  // Cart shares ownership
}

// Good: Using weak_ptr to break circular dependencies
class Order {
private:
    std::weak_ptr<Customer> customer_;  // Avoid circular ref with Customer->Order
public:
    std::shared_ptr<Customer> getCustomer() const {
        return customer_.lock();  // Safely get shared_ptr if still alive
    }
};

// RAII - Resource Acquisition Is Initialization
class DatabaseConnection {
private:
    void* connection_;
public:
    DatabaseConnection() {
        connection_ = openConnection();  // Acquire
    }
    ~DatabaseConnection() {
        if (connection_) {
            closeConnection(connection_);  // Release in destructor
        }
    }
    // Delete copy, allow move
    DatabaseConnection(const DatabaseConnection&) = delete;
    DatabaseConnection& operator=(const DatabaseConnection&) = delete;
    DatabaseConnection(DatabaseConnection&&) = default;
    DatabaseConnection& operator=(DatabaseConnection&&) = default;
};
```

**Assignment**:
- Create Product and Category classes with smart pointers
- Implement proper error handling
- Write unit tests with Catch2
- Use modern C++ features (auto, lambdas, ranges)
- Memory leak testing with Valgrind

---

#### Day 3-4: Build System (CMake) & Project Setup
**Learning Objectives**:
- CMake project configuration
- Managing dependencies
- Build configuration for different platforms
- Integration with development tools

**CMakeLists.txt**:
```cmake
cmake_minimum_required(VERSION 3.15)
project(ShopFlowBackend
    VERSION 1.0.0
    DESCRIPTION "ShopFlow e-commerce backend in C++"
    LANGUAGES CXX
)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

# Output directories
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)

# Find required packages
find_package(Boost REQUIRED COMPONENTS system)
find_package(OpenSSL REQUIRED)
find_package(MySQL REQUIRED)
find_package(fmt REQUIRED)
find_package(spdlog REQUIRED)

# Core library
add_library(shopflow_core STATIC
    src/domain/Product.cpp
    src/domain/Category.cpp
    src/domain/Order.cpp
    src/domain/User.cpp
    src/repository/ProductRepository.cpp
    src/repository/CategoryRepository.cpp
)

target_include_directories(shopflow_core PUBLIC
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>
    $<INSTALL_INTERFACE:include>
)

target_link_libraries(shopflow_core PUBLIC
    Boost::system
    MySQL::MySQL
    fmt::fmt
    spdlog::spdlog
)

# REST API executable
add_executable(shopflow_api
    src/main.cpp
    src/api/ProductController.cpp
    src/api/CategoryController.cpp
    src/api/Server.cpp
)

target_link_libraries(shopflow_api PRIVATE
    shopflow_core
    Boost::system
    OpenSSL::SSL OpenSSL::Crypto
)

# Tests
enable_testing()
find_package(Catch2 REQUIRED)

add_executable(shopflow_tests
    tests/ProductTests.cpp
    tests/RepositoryTests.cpp
)

target_link_libraries(shopflow_tests PRIVATE
    shopflow_core
    Catch2::Catch2WithMain
)

add_test(NAME ShopFlowTests COMMAND shopflow_tests)
```

**Project Structure**:
```
ShopFlowBackend/
├── CMakeLists.txt
├── include/
│   ├── domain/
│   │   ├── Product.hpp
│   │   ├── Category.hpp
│   │   ├── Order.hpp
│   │   └── User.hpp
│   ├── repository/
│   │   ├── ProductRepository.hpp
│   │   └── CategoryRepository.hpp
│   ├── service/
│   │   ├── ProductService.hpp
│   │   └── OrderService.hpp
│   ├── api/
│   │   ├── Server.hpp
│   │   ├── ProductController.hpp
│   │   └── Handlers.hpp
│   └── util/
│       ├── Logger.hpp
│       └── Database.hpp
├── src/
│   ├── main.cpp
│   ├── domain/
│   ├── repository/
│   ├── service/
│   ├── api/
│   └── util/
├── tests/
│   ├── ProductTests.cpp
│   ├── RepositoryTests.cpp
│   └── IntegrationTests.cpp
└── conanfile.txt  (or vcpkg.json for package management)
```

---

#### Day 5: Async I/O with Asio & Beast
**Learning Objectives**:
- Asio async operations
- Beast HTTP library
- Socket programming
- Non-blocking I/O patterns

**Basic HTTP Server with Beast**:
```cpp
// Server.hpp
#pragma once
#include <beast/core.hpp>
#include <beast/http.hpp>
#include <beast/ssl.hpp>
#include <boost/asio.hpp>
#include <memory>
#include <string>
#include <functional>

namespace beast = boost::beast;
namespace http = beast::http;
namespace net = boost::asio;
using tcp = net::ip::tcp;

class HttpServer {
private:
    net::io_context ioc_;
    tcp::acceptor acceptor_;
    std::string host_;
    unsigned short port_;
    
public:
    HttpServer(const std::string& host, unsigned short port);
    
    void start();
    void stop();
    
    using RequestHandler = std::function<
        http::response<http::string_body>(
            const http::request<http::string_body>&
        )
    >;
    
    void registerHandler(const std::string& path, RequestHandler handler);
    
private:
    void acceptConnection();
    void handleConnection(std::shared_ptr<tcp::socket> socket);
};

// Server.cpp
#include "Server.hpp"
#include <iostream>
#include <map>
#include <memory>

HttpServer::HttpServer(const std::string& host, unsigned short port)
    : acceptor_(ioc_, tcp::endpoint(net::ip::make_address(host), port)),
      host_(host), port_(port) {}

void HttpServer::start() {
    std::cout << "Server listening on " << host_ << ":" << port_ << std::endl;
    acceptConnection();
    ioc_.run();
}

void HttpServer::acceptConnection() {
    auto socket = std::make_shared<tcp::socket>(ioc_);
    acceptor_.async_accept(*socket,
        [this, socket](beast::error_code ec) {
            if (!ec) {
                handleConnection(socket);
            }
            acceptConnection();  // Accept next connection
        });
}

void HttpServer::handleConnection(std::shared_ptr<tcp::socket> socket) {
    auto buffer = std::make_shared<beast::flat_buffer>();
    auto request = std::make_shared<http::request<http::string_body>>();
    
    // Read HTTP request
    http::async_read(*socket, *buffer, *request,
        [this, socket, buffer, request](beast::error_code ec, std::size_t bytes_transferred) {
            if (!ec) {
                // Process request and send response
                http::response<http::string_body> response;
                response.version(request->version());
                response.result(http::status::ok);
                response.set(http::field::content_type, "application/json");
                response.body() = R"({"status": "ok"})";
                response.prepare_payload();
                
                // Send response
                http::async_write(*socket, response,
                    [socket](beast::error_code ec, std::size_t) {
                        if (ec) std::cerr << "Write error: " << ec.message() << std::endl;
                    });
            }
        });
}
```

---

#### Day 6-7: REST API Design & Request Routing
**Learning Objectives**:
- HTTP routing patterns
- Request/response processing
- JSON serialization with nlohmann/json
- Route parameter extraction

**REST API Implementation**:
```cpp
// ProductController.hpp
#pragma once
#include <beast/http.hpp>
#include <memory>
#include <string>
#include "ProductService.hpp"

namespace http = beast::http;

class ProductController {
private:
    std::shared_ptr<ProductService> productService_;
    
public:
    explicit ProductController(std::shared_ptr<ProductService> service);
    
    // GET /api/v1/products
    http::response<http::string_body> getProducts(
        const http::request<http::string_body>& request);
    
    // GET /api/v1/products/{id}
    http::response<http::string_body> getProduct(
        const http::request<http::string_body>& request, long productId);
    
    // POST /api/v1/products
    http::response<http::string_body> createProduct(
        const http::request<http::string_body>& request);
    
    // PUT /api/v1/products/{id}
    http::response<http::string_body> updateProduct(
        const http::request<http::string_body>& request, long productId);
    
    // DELETE /api/v1/products/{id}
    http::response<http::string_body> deleteProduct(
        const http::request<http::string_body>& request, long productId);
};

// ProductController.cpp
#include "ProductController.hpp"
#include <nlohmann/json.hpp>
#include <spdlog/spdlog.h>

using json = nlohmann::json;

ProductController::ProductController(std::shared_ptr<ProductService> service)
    : productService_(service) {}

http::response<http::string_body> ProductController::getProducts(
    const http::request<http::string_body>& request) {
    
    try {
        auto products = productService_->getAllProducts();
        
        json jsonResponse = json::array();
        for (const auto& product : products) {
            jsonResponse.push_back({
                {"id", product->getId()},
                {"name", product->getName()},
                {"price", product->getPrice()},
                {"stockQuantity", product->getStockQuantity()}
            });
        }
        
        http::response<http::string_body> response;
        response.version(request.version());
        response.result(http::status::ok);
        response.set(http::field::content_type, "application/json");
        response.body() = jsonResponse.dump();
        response.prepare_payload();
        
        return response;
    } catch (const std::exception& e) {
        http::response<http::string_body> response;
        response.result(http::status::internal_server_error);
        response.set(http::field::content_type, "application/json");
        response.body() = json{{"error", e.what()}}.dump();
        response.prepare_payload();
        return response;
    }
}

http::response<http::string_body> ProductController::getProduct(
    const http::request<http::string_body>& request, long productId) {
    
    try {
        auto product = productService_->getProductById(productId);
        if (!product) {
            http::response<http::string_body> response;
            response.result(http::status::not_found);
            response.set(http::field::content_type, "application/json");
            response.body() = json{{"error", "Product not found"}}.dump();
            response.prepare_payload();
            return response;
        }
        
        json jsonResponse{
            {"id", product->getId()},
            {"name", product->getName()},
            {"price", product->getPrice()},
            {"stockQuantity", product->getStockQuantity()}
        };
        
        http::response<http::string_body> response;
        response.version(request.version());
        response.result(http::status::ok);
        response.set(http::field::content_type, "application/json");
        response.body() = jsonResponse.dump();
        response.prepare_payload();
        
        return response;
    } catch (const std::exception& e) {
        http::response<http::string_body> response;
        response.result(http::status::internal_server_error);
        response.set(http::field::content_type, "application/json");
        response.body() = json{{"error", e.what()}}.dump();
        response.prepare_payload();
        return response;
    }
}

http::response<http::string_body> ProductController::createProduct(
    const http::request<http::string_body>& request) {
    
    try {
        auto jsonBody = json::parse(request.body());
        
        // Validate input
        if (!jsonBody.contains("name") || !jsonBody.contains("price")) {
            http::response<http::string_body> response;
            response.result(http::status::bad_request);
            response.set(http::field::content_type, "application/json");
            response.body() = json{{"error", "Missing required fields"}}.dump();
            response.prepare_payload();
            return response;
        }
        
        auto product = productService_->createProduct(
            jsonBody["name"],
            jsonBody["price"],
            jsonBody.value("stockQuantity", 0)
        );
        
        json jsonResponse{
            {"id", product->getId()},
            {"name", product->getName()},
            {"price", product->getPrice()},
            {"stockQuantity", product->getStockQuantity()}
        };
        
        http::response<http::string_body> response;
        response.version(request.version());
        response.result(http::status::created);
        response.set(http::field::content_type, "application/json");
        response.body() = jsonResponse.dump();
        response.prepare_payload();
        
        return response;
    } catch (const json::exception& e) {
        http::response<http::string_body> response;
        response.result(http::status::bad_request);
        response.set(http::field::content_type, "application/json");
        response.body() = json{{"error", "Invalid JSON"}}.dump();
        response.prepare_payload();
        return response;
    } catch (const std::exception& e) {
        http::response<http::string_body> response;
        response.result(http::status::internal_server_error);
        response.set(http::field::content_type, "application/json");
        response.body() = json{{"error", e.what()}}.dump();
        response.prepare_payload();
        return response;
    }
}
```

---

### Week 2: Database Integration & Concurrency

#### Day 8-9: MySQL Database Integration
**Learning Objectives**:
- MySQL C++ connector
- Connection pooling
- Query execution
- Result set handling
- Prepared statements for SQL injection prevention

**Database Layer**:
```cpp
// Database.hpp
#pragma once
#include <mysql_connection.h>
#include <cppconn/driver.h>
#include <cppconn/exception.h>
#include <cppconn/resultset.h>
#include <cppconn/statement.h>
#include <memory>
#include <string>
#include <queue>
#include <mutex>

class DatabasePool {
private:
    sql::Driver* driver_;
    std::string host_;
    std::string user_;
    std::string password_;
    std::string database_;
    std::queue<std::unique_ptr<sql::Connection>> connections_;
    std::mutex mutex_;
    static constexpr int POOL_SIZE = 10;
    
public:
    DatabasePool(const std::string& host, const std::string& user,
                const std::string& password, const std::string& database);
    ~DatabasePool();
    
    std::unique_ptr<sql::Connection> getConnection();
    void returnConnection(std::unique_ptr<sql::Connection> connection);
    
private:
    std::unique_ptr<sql::Connection> createConnection();
};

class Database {
private:
    std::shared_ptr<DatabasePool> pool_;
    
public:
    explicit Database(std::shared_ptr<DatabasePool> pool);
    
    template<typename T>
    std::vector<T> query(const std::string& sql);
    
    bool execute(const std::string& sql);
    
    std::unique_ptr<sql::ResultSet> executeQuery(const std::string& sql);
};

// Database.cpp
#include "Database.hpp"
#include <spdlog/spdlog.h>

DatabasePool::DatabasePool(const std::string& host, const std::string& user,
                          const std::string& password, const std::string& database)
    : host_(host), user_(user), password_(password), database_(database) {
    driver_ = sql::mysql::get_mysql_driver_instance();
    
    // Initialize pool with connections
    for (int i = 0; i < POOL_SIZE; ++i) {
        connections_.push(createConnection());
    }
}

DatabasePool::~DatabasePool() {
    std::lock_guard<std::mutex> lock(mutex_);
    while (!connections_.empty()) {
        connections_.pop();
    }
}

std::unique_ptr<sql::Connection> DatabasePool::createConnection() {
    auto conn = std::unique_ptr<sql::Connection>(
        driver_->connect(host_, user_, password_)
    );
    conn->setSchema(database_);
    return conn;
}

std::unique_ptr<sql::Connection> DatabasePool::getConnection() {
    std::lock_guard<std::mutex> lock(mutex_);
    
    while (connections_.empty()) {
        // Wait for connection or create new one
        std::this_thread::yield();
    }
    
    auto conn = std::move(connections_.front());
    connections_.pop();
    return conn;
}

void DatabasePool::returnConnection(std::unique_ptr<sql::Connection> connection) {
    std::lock_guard<std::mutex> lock(mutex_);
    if (connection && connection->isValid()) {
        connections_.push(std::move(connection));
    }
}

// Repository using database
class ProductRepository {
private:
    std::shared_ptr<Database> database_;
    
public:
    explicit ProductRepository(std::shared_ptr<Database> database)
        : database_(database) {}
    
    std::vector<std::shared_ptr<Product>> findAll() {
        auto resultSet = database_->executeQuery(
            "SELECT id, name, description, price, stock_quantity FROM products"
        );
        
        std::vector<std::shared_ptr<Product>> products;
        while (resultSet->next()) {
            auto product = std::make_shared<Product>(
                resultSet->getString("name"),
                resultSet->getDouble("price"),
                nullptr
            );
            // Set ID from database
            products.push_back(product);
        }
        return products;
    }
    
    std::shared_ptr<Product> findById(long id) {
        std::string sql = "SELECT id, name, description, price, stock_quantity "
                         "FROM products WHERE id = " + std::to_string(id);
        
        auto resultSet = database_->executeQuery(sql);
        if (resultSet->next()) {
            auto product = std::make_shared<Product>(
                resultSet->getString("name"),
                resultSet->getDouble("price"),
                nullptr
            );
            return product;
        }
        return nullptr;
    }
    
    bool save(const std::shared_ptr<Product>& product) {
        std::string sql = "INSERT INTO products (name, description, price, stock_quantity) "
                         "VALUES ('" + product->getName() + "', '', " +
                         std::to_string(product->getPrice()) + ", 0)";
        
        return database_->execute(sql);
    }
};
```

---

#### Day 10-11: Thread Pools & Async Task Execution
**Learning Objectives**:
- Thread pool design patterns
- Async task execution
- Lock-free data structures
- Deadlock prevention

**Thread Pool Implementation**:
```cpp
// ThreadPool.hpp
#pragma once
#include <thread>
#include <queue>
#include <functional>
#include <mutex>
#include <condition_variable>
#include <memory>
#include <vector>

class ThreadPool {
private:
    std::vector<std::thread> workers_;
    std::queue<std::function<void()>> tasks_;
    std::mutex tasks_mutex_;
    std::condition_variable cv_;
    bool shutdown_ = false;
    
public:
    explicit ThreadPool(size_t num_threads = std::thread::hardware_concurrency());
    ~ThreadPool();
    
    template<typename F, typename... Args>
    auto enqueue(F&& f, Args&&... args) 
        -> std::future<typename std::invoke_result<F, Args...>::type> {
        
        using return_type = typename std::invoke_result<F, Args...>::type;
        auto task = std::make_shared<std::packaged_task<return_type()>>(
            std::bind(std::forward<F>(f), std::forward<Args>(args)...)
        );
        
        auto res = task->get_future();
        {
            std::unique_lock<std::mutex> lock(tasks_mutex_);
            if (shutdown_) {
                throw std::runtime_error("ThreadPool is shutdown");
            }
            tasks_.emplace([task]() { (*task)(); });
        }
        cv_.notify_one();
        return res;
    }
    
private:
    void workerThread();
};

// ThreadPool.cpp
#include "ThreadPool.hpp"

ThreadPool::ThreadPool(size_t num_threads) {
    for (size_t i = 0; i < num_threads; ++i) {
        workers_.emplace_back(&ThreadPool::workerThread, this);
    }
}

ThreadPool::~ThreadPool() {
    {
        std::unique_lock<std::mutex> lock(tasks_mutex_);
        shutdown_ = true;
    }
    cv_.notify_all();
    for (auto& worker : workers_) {
        worker.join();
    }
}

void ThreadPool::workerThread() {
    while (true) {
        std::unique_lock<std::mutex> lock(tasks_mutex_);
        cv_.wait(lock, [this] { return !tasks_.empty() || shutdown_; });
        
        if (shutdown_ && tasks_.empty()) break;
        
        if (!tasks_.empty()) {
            auto task = std::move(tasks_.front());
            tasks_.pop();
            lock.unlock();
            task();
        }
    }
}

// Usage example
class OrderService {
private:
    std::shared_ptr<ThreadPool> thread_pool_;
    
public:
    void processOrderAsync(std::shared_ptr<Order> order) {
        auto future = thread_pool_->enqueue([this, order]() {
            return this->processOrder(order);
        });
        
        // Continue without blocking
        // Can retrieve result later with future.get()
    }
};
```

---

#### Day 12-14: Concurrency & Thread Safety
**Learning Objectives**:
- Mutexes and locks
- Atomic operations
- Race condition prevention
- Lock-free programming patterns

**Concurrent Data Structures**:
```cpp
// ThreadSafeCache.hpp
#pragma once
#include <unordered_map>
#include <shared_mutex>
#include <memory>
#include <optional>

template<typename Key, typename Value>
class ThreadSafeCache {
private:
    mutable std::shared_mutex mutex_;
    std::unordered_map<Key, std::shared_ptr<Value>> cache_;
    
public:
    void put(const Key& key, std::shared_ptr<Value> value) {
        std::unique_lock<std::shared_mutex> lock(mutex_);
        cache_[key] = value;
    }
    
    std::optional<std::shared_ptr<Value>> get(const Key& key) const {
        std::shared_lock<std::shared_mutex> lock(mutex_);
        auto it = cache_.find(key);
        if (it != cache_.end()) {
            return it->second;
        }
        return std::nullopt;
    }
    
    bool contains(const Key& key) const {
        std::shared_lock<std::shared_mutex> lock(mutex_);
        return cache_.find(key) != cache_.end();
    }
    
    void remove(const Key& key) {
        std::unique_lock<std::shared_mutex> lock(mutex_);
        cache_.erase(key);
    }
    
    void clear() {
        std::unique_lock<std::shared_mutex> lock(mutex_);
        cache_.clear();
    }
};

// Usage
class ProductCache {
private:
    ThreadSafeCache<long, Product> cache_;
    
public:
    std::shared_ptr<Product> getProduct(long id) {
        // Multiple threads can read simultaneously
        if (auto cached = cache_.get(id)) {
            return cached.value();
        }
        return nullptr;
    }
    
    void putProduct(long id, std::shared_ptr<Product> product) {
        // Only one thread can write at a time
        cache_.put(id, product);
    }
};

// Atomic operations for counters
class RequestCounter {
private:
    std::atomic<long> count_{0};
    std::atomic<long> errors_{0};
    
public:
    void incrementCount() {
        count_.fetch_add(1, std::memory_order_relaxed);
    }
    
    void incrementErrors() {
        errors_.fetch_add(1, std::memory_order_relaxed);
    }
    
    long getCount() const {
        return count_.load(std::memory_order_acquire);
    }
    
    long getErrors() const {
        return errors_.load(std::memory_order_acquire);
    }
};
```

---

### Week 3: gRPC Microservices & Performance Optimization

#### Day 15-16: gRPC for Microservices
**Learning Objectives**:
- Protocol Buffers (protobuf)
- gRPC service definition
- Async gRPC handlers
- Service-to-service communication

**Protocol Buffer Definition**:
```protobuf
// product.proto
syntax = "proto3";

package shopflow;

service ProductService {
    rpc GetProduct (GetProductRequest) returns (ProductResponse) {}
    rpc ListProducts (ListProductsRequest) returns (stream ProductResponse) {}
    rpc CreateProduct (CreateProductRequest) returns (ProductResponse) {}
    rpc UpdateProduct (UpdateProductRequest) returns (ProductResponse) {}
    rpc DeleteProduct (DeleteProductRequest) returns (DeleteResponse) {}
}

message GetProductRequest {
    int64 id = 1;
}

message CreateProductRequest {
    string name = 1;
    double price = 2;
    int32 stock_quantity = 3;
    int64 category_id = 4;
}

message UpdateProductRequest {
    int64 id = 1;
    string name = 2;
    double price = 3;
    int32 stock_quantity = 4;
}

message DeleteProductRequest {
    int64 id = 1;
}

message ProductResponse {
    int64 id = 1;
    string name = 2;
    string description = 3;
    double price = 4;
    int32 stock_quantity = 5;
    int64 category_id = 6;
}

message ListProductsRequest {
    int64 category_id = 1;
    int32 page = 2;
    int32 page_size = 3;
}

message DeleteResponse {
    bool success = 1;
    string message = 2;
}
```

**gRPC Service Implementation**:
```cpp
// ProductServiceImpl.h
#pragma once
#include <grpcpp/grpcpp.h>
#include "product.grpc.pb.h"
#include "ProductService.hpp"
#include <memory>

using grpc::ServerContext;
using grpc::Status;
using grpc::StatusCode;

class ProductServiceImpl : public shopflow::ProductService::Service {
private:
    std::shared_ptr<ProductService> product_service_;
    
public:
    explicit ProductServiceImpl(std::shared_ptr<ProductService> service)
        : product_service_(service) {}
    
    Status GetProduct(ServerContext* context,
                     const shopflow::GetProductRequest* request,
                     shopflow::ProductResponse* response) override;
    
    Status CreateProduct(ServerContext* context,
                        const shopflow::CreateProductRequest* request,
                        shopflow::ProductResponse* response) override;
    
    Status ListProducts(ServerContext* context,
                       const shopflow::ListProductsRequest* request,
                       grpc::ServerWriter<shopflow::ProductResponse>* writer) override;
};

// ProductServiceImpl.cpp
#include "ProductServiceImpl.h"
#include <spdlog/spdlog.h>

Status ProductServiceImpl::GetProduct(ServerContext* context,
                                    const shopflow::GetProductRequest* request,
                                    shopflow::ProductResponse* response) {
    try {
        auto product = product_service_->getProductById(request->id());
        if (!product) {
            return Status(StatusCode::NOT_FOUND, "Product not found");
        }
        
        response->set_id(product->getId());
        response->set_name(product->getName());
        response->set_price(product->getPrice());
        response->set_stock_quantity(product->getStockQuantity());
        
        return Status::OK;
    } catch (const std::exception& e) {
        spdlog::error("Error in GetProduct: {}", e.what());
        return Status(StatusCode::INTERNAL, e.what());
    }
}

Status ProductServiceImpl::CreateProduct(ServerContext* context,
                                       const shopflow::CreateProductRequest* request,
                                       shopflow::ProductResponse* response) {
    try {
        auto product = product_service_->createProduct(
            request->name(),
            request->price(),
            request->stock_quantity()
        );
        
        response->set_id(product->getId());
        response->set_name(product->getName());
        response->set_price(product->getPrice());
        response->set_stock_quantity(product->getStockQuantity());
        
        return Status::OK;
    } catch (const std::exception& e) {
        return Status(StatusCode::INTERNAL, e.what());
    }
}

Status ProductServiceImpl::ListProducts(ServerContext* context,
                                      const shopflow::ListProductsRequest* request,
                                      grpc::ServerWriter<shopflow::ProductResponse>* writer) {
    try {
        auto products = product_service_->getAllProducts();
        
        for (const auto& product : products) {
            shopflow::ProductResponse response;
            response.set_id(product->getId());
            response.set_name(product->getName());
            response.set_price(product->getPrice());
            response.set_stock_quantity(product->getStockQuantity());
            
            if (!writer->Write(response)) {
                return Status(StatusCode::CANCELLED, "Client cancelled");
            }
        }
        
        return Status::OK;
    } catch (const std::exception& e) {
        return Status(StatusCode::INTERNAL, e.what());
    }
}

// Server setup
int main() {
    std::string server_address = "0.0.0.0:50051";
    
    auto product_service = std::make_shared<ProductService>();
    ProductServiceImpl service(product_service);
    
    grpc::ServerBuilder builder;
    builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
    builder.RegisterService(&service);
    
    std::unique_ptr<grpc::Server> server(builder.BuildAndStart());
    spdlog::info("gRPC Server listening on {}", server_address);
    
    server->Wait();
    
    return 0;
}
```

---

#### Day 17-18: Performance Profiling & Optimization
**Learning Objectives**:
- Profiling with perf and Valgrind
- Memory optimization
- CPU optimization
- Load testing

**Performance Optimization Example**:
```cpp
// Before: Inefficient string handling
std::string Product::toString() {
    std::string result = "Product: ";
    result += std::to_string(id_);
    result += " Name: ";
    result += name_;
    result += " Price: ";
    result += std::to_string(price_);
    return result;  // Multiple allocations
}

// After: Optimized with reserve and move
std::string Product::toString() {
    std::string result;
    result.reserve(100);  // Pre-allocate
    result += "Product: ";
    result += std::to_string(id_);
    result += " Name: ";
    result += name_;
    result += " Price: ";
    result += std::to_string(price_);
    return result;  // RVO - no copy
}

// Even better: Use fmt library
#include <fmt/format.h>

std::string Product::toString() {
    return fmt::format("Product: {} Name: {} Price: {}", 
                      id_, name_, price_);
}

// Benchmark different approaches
void benchmarkProductString() {
    auto product = std::make_shared<Product>("Test", 99.99, nullptr);
    
    auto start = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < 1000000; ++i) {
        auto str = product->toString();
        volatile auto _ = str;  // Prevent optimization
    }
    auto end = std::chrono::high_resolution_clock::now();
    
    auto duration = std::chrono::duration_cast<std::chrono::milliseconds>(end - start);
    std::cout << "Time: " << duration.count() << "ms" << std::endl;
}

// Use move semantics effectively
std::vector<std::shared_ptr<Product>> getAllProductsOptimized() {
    std::vector<std::shared_ptr<Product>> products;
    products.reserve(1000);  // Pre-allocate if size is known
    
    // Fetch from database and move directly
    for (int i = 0; i < 1000; ++i) {
        products.push_back(std::make_shared<Product>("Product" + std::to_string(i), 99.99, nullptr));
    }
    
    return products;  // Move, not copy
}
```

---

#### Day 19-21: Testing & Final Project
**Learning Objectives**:
- Unit testing with Catch2
- Integration testing
- Performance testing
- Load testing with wrk

**Comprehensive Test Suite**:
```cpp
#include <catch2/catch.hpp>
#include "Product.hpp"
#include "ProductService.hpp"
#include "ThreadPool.hpp"

TEST_CASE("Product creation and properties", "[Product]") {
    auto product = std::make_shared<Product>("Test Product", 99.99, nullptr);
    
    REQUIRE(product->getName() == "Test Product");
    REQUIRE(product->getPrice() == 99.99);
    REQUIRE(product->getStockQuantity() == 0);
}

TEST_CASE("Product stock management", "[Product]") {
    auto product = std::make_shared<Product>("Test", 99.99, nullptr);
    product->setStockQuantity(10);
    
    REQUIRE(product->decrementStock(5));
    REQUIRE(product->getStockQuantity() == 5);
    REQUIRE_FALSE(product->decrementStock(10));  // Can't decrement more than available
}

TEST_CASE("Thread-safe cache operations", "[Cache]") {
    ThreadSafeCache<int, std::string> cache;
    
    cache.put(1, std::make_shared<std::string>("value1"));
    auto result = cache.get(1);
    
    REQUIRE(result.has_value());
    REQUIRE(*result.value() == "value1");
}

TEST_CASE("Concurrent thread pool execution", "[ThreadPool]") {
    ThreadPool pool(4);
    std::atomic<int> counter{0};
    
    std::vector<std::future<void>> futures;
    for (int i = 0; i < 100; ++i) {
        futures.push_back(pool.enqueue([&counter]() {
            counter.fetch_add(1);
        }));
    }
    
    for (auto& future : futures) {
        future.get();
    }
    
    REQUIRE(counter.load() == 100);
}
```

**Final Project Deliverables**:
- Complete REST API service in C++
- gRPC service definition & implementation
- Thread-safe concurrent request handling
- Performance benchmarks & analysis
- Comprehensive test suite (>80% coverage)
- Deployment guide
- Performance optimization report

---

## 📊 Module A (C++) Success Criteria

**Must Complete**:
- ✅ REST API server with 15+ endpoints
- ✅ MySQL database integration with pooling
- ✅ Thread pool for concurrent request handling
- ✅ gRPC microservice implementation
- ✅ Comprehensive error handling & logging
- ✅ Unit tests (>85% coverage)
- ✅ Performance profiling & optimization
- ✅ Memory leak free (Valgrind clean)

**Evaluation**:
- Code quality & modern C++ practices: 30%
- Feature completeness: 25%
- Performance optimization: 20%
- Test coverage: 15%
- Documentation: 10%

---

**Module Duration**: 30 days
**Start Date**: [INSERT DATE]
**End Date**: [INSERT DATE]
**Last Updated**: August 6, 2026

