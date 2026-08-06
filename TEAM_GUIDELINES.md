# Team Guidelines & Best Practices

## 📋 Communication & Collaboration Standards

### Daily Standup Format
**Time**: 9:00 AM (15 minutes)
**Participants**: All 3 developers
**Format**: Async or Video call

**Standard Template**:
```
Yesterday:
- Completed: [specific tasks]
- Lines of code written: [number]
- Tests passed: [number]

Today:
- Planning to complete: [specific tasks]
- Estimated LOC: [number]

Blockers:
- Issue 1: [description] - Priority: [High/Medium/Low]
- Issue 2: [description] - Priority: [High/Medium/Low]

Help Needed:
- [Specific areas where team support is needed]
```

### Weekly Meeting Schedule
- **Monday 9:00 AM**: Weekly planning & module overview (30 min)
- **Wednesday 2:00 PM**: Mid-week checkpoint (15 min)
- **Friday 4:00 PM**: Demo & retrospective (1 hour)

### Code Review Standards
- **Turnaround Time**: 24 hours maximum
- **Minimum Reviewers**: 2 developers
- **Approval Required**: Both reviewers must approve
- **Changes Requested**: Must be addressed within 48 hours

---

## 💻 Code Quality Standards

### Naming Conventions

**Java**:
```java
// Classes: PascalCase
public class ProductService { }

// Methods: camelCase
public void createProduct() { }

// Constants: SCREAMING_SNAKE_CASE
private static final int MAX_RETRIES = 3;

// Variables: camelCase
private String productName;
```

**C++**:
```cpp
// Classes: PascalCase
class ProductService { };

// Methods: camelCase
void createProduct() { }

// Constants: SCREAMING_SNAKE_CASE or kPascalCase
static constexpr int MAX_RETRIES = 3;
static constexpr int kMaxRetries = 3;

// Member variables: snake_case_
class Product {
private:
    std::string name_;
    double price_;
};
```

### Comment Requirements

**Java**:
```java
/**
 * Creates a new product in the system.
 * 
 * @param request the product creation request
 * @return the created product DTO
 * @throws InvalidProductException if product data is invalid
 * @throws DatabaseException if database operation fails
 */
public ProductDTO createProduct(CreateProductRequest request) {
    // Implementation
}
```

**C++**:
```cpp
/**
 * Creates a new product in the system.
 * 
 * @param request The product creation request
 * @return The created product, or nullptr if creation failed
 * @throws std::invalid_argument If product data is invalid
 * @throws std::runtime_error If database operation fails
 */
std::shared_ptr<Product> createProduct(const CreateProductRequest& request);
```

### Method Length & Complexity
- Maximum method length: 50 lines (excluding comments)
- Cyclomatic complexity: < 10
- Maximum method parameters: 5
- Extract complex logic into helper methods

### Test Coverage Requirements
- Minimum: 80% code coverage
- Target: 90% code coverage
- All public methods must have tests
- Test both success and error paths

### Error Handling
```java
// Good: Specific exception handling
try {
    product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
} catch (ProductNotFoundException e) {
    log.error("Product not found with id: {}", id);
    throw e;
} catch (DatabaseException e) {
    log.error("Database error while fetching product", e);
    throw new ServiceException("Failed to fetch product", e);
}

// Bad: Catching generic exception
try {
    // code
} catch (Exception e) {
    e.printStackTrace();  // Don't do this!
}
```

---

## 📝 Documentation Standards

### README.md Requirements
Each module must have a README with:
- [ ] Project description
- [ ] Prerequisites & dependencies
- [ ] Installation instructions
- [ ] How to run the application
- [ ] How to run tests
- [ ] API documentation link
- [ ] Architecture overview
- [ ] Troubleshooting guide
- [ ] Contributing guidelines

### API Documentation

**Required for all endpoints**:
```markdown
## GET /api/v1/products

Retrieves all products with pagination support.

### Request Parameters
- `page` (query, optional, default=0): Page number (0-indexed)
- `limit` (query, optional, default=20): Items per page
- `sortBy` (query, optional, default=name): Sort field
- `category` (query, optional): Filter by category ID

### Response
- Status: 200 OK
- Body: Array of ProductDTO

### Example
```
curl -X GET "http://localhost:8080/api/v1/products?page=0&limit=10"
```

### Error Responses
- 400 Bad Request: Invalid parameters
- 401 Unauthorized: Missing authentication
- 500 Internal Server Error: Server error
```

### Architecture Documentation

**Required sections**:
1. System architecture diagram
2. Component responsibilities
3. Data flow diagrams
4. API contracts
5. Database schema
6. Security considerations
7. Performance considerations
8. Deployment architecture

---

## 🔄 Git Workflow

### Branch Naming Convention
```
feature/[developer-name]-[short-description]
  e.g., feature/kenneth-user-authentication

bugfix/[developer-name]-[short-description]
  e.g., bugfix/dev2-memory-leak

hotfix/[developer-name]-[short-description]
  e.g., hotfix/dev3-critical-error
```

### Commit Message Format
```
[TYPE] [SCOPE]: [SUBJECT]

[BODY]

[FOOTER]

Example:
feat(auth): implement JWT token validation

- Add JwtTokenProvider class
- Validate token expiration
- Handle invalid tokens with proper error response

Fixes #123
```

**TYPE**: feat, fix, docs, style, refactor, test, chore
**SCOPE**: auth, product, order, user, etc.
**SUBJECT**: Max 50 characters, present tense
**BODY**: Explain what and why, wrap at 72 characters
**FOOTER**: Reference issues and breaking changes

### Pull Request Process
1. Create feature branch from `dev`
2. Write code and tests
3. Ensure all tests pass locally
4. Push branch and create PR
5. Assign 2 reviewers
6. Address review comments
7. Rebase on `dev` if needed
8. Squash commits (1 commit per feature)
9. Merge to `dev`
10. Delete feature branch

### Merge Conflicts Resolution
```bash
# Prevent conflicts with frequent pulls
git pull origin dev

# When conflicts occur
git merge --no-ff feature/your-branch
# Resolve conflicts in editor
git add .
git commit -m "Merge feature/your-branch into dev"

# For rebasing (cleaner history)
git rebase dev
git merge --ff-only feature/your-branch
```

---

## 🧪 Testing Standards

### Test Structure
```java
// AAA Pattern: Arrange, Act, Assert
@Test
public void testProductCreation() {
    // Arrange: Set up test data
    CreateProductRequest request = new CreateProductRequest();
    request.setName("Test Product");
    request.setPrice(BigDecimal.valueOf(99.99));
    
    // Act: Execute the operation
    ProductDTO result = productService.createProduct(request);
    
    // Assert: Verify the result
    assertThat(result).isNotNull();
    assertThat(result.getName()).isEqualTo("Test Product");
    assertThat(result.getPrice()).isEqualTo(BigDecimal.valueOf(99.99));
}
```

### Test Naming Convention
```
test[What][Condition][Expected Result]

Examples:
testCreateProduct_ValidInput_ReturnsProduct()
testGetProduct_NonExistentId_ThrowsNotFoundException()
testUpdateProduct_UnauthorizedUser_ThrowsUnauthorizedException()
```

### Test Data Management
- Use @BeforeEach for test setup
- Use @AfterEach for cleanup
- Use test builders for complex objects
- Keep test data minimal and focused
- Use realistic test data values

### Mocking Guidelines
```java
// Good: Mock external dependencies
@Mock
private ProductRepository productRepository;

@Test
public void testGetProduct() {
    when(productRepository.findById(1L))
        .thenReturn(Optional.of(new Product(...)));
    
    Product result = productService.getProduct(1L);
    
    verify(productRepository, times(1)).findById(1L);
}

// Bad: Over-mocking
@Mock
private Product product;  // Don't mock the class being tested
```

---

## 🔒 Security Standards

### Authentication & Authorization
- Use strong password hashing (BCrypt minimum)
- Implement JWT with reasonable expiration (1-24 hours)
- Validate all inputs on both frontend and backend
- Use HTTPS for all API communication
- Implement CORS properly
- Validate JWT signature on every request

### Input Validation
```java
// Good: Comprehensive validation
@PostMapping("/products")
public ResponseEntity<ProductDTO> createProduct(
        @Valid @RequestBody CreateProductRequest request) {
    // Spring automatically validates @Valid annotated objects
    // Follow up with business logic validation
    
    if (request.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
        throw new InvalidProductException("Price must be positive");
    }
    
    return ResponseEntity.ok(productService.createProduct(request));
}

// Bad: No validation
public ResponseEntity<ProductDTO> createProduct(CreateProductRequest request) {
    productService.createProduct(request);  // Dangerous!
}
```

### SQL Injection Prevention
```java
// Good: Use parameterized queries
@Query("SELECT p FROM Product p WHERE p.id = :id")
Product findById(@Param("id") Long id);

// Bad: String concatenation
String query = "SELECT * FROM products WHERE id = " + id;  // SQL injection risk!
```

### Secrets Management
```yaml
# application.yml - Safe approach
spring:
  datasource:
    password: ${DB_PASSWORD}  # From environment variable
    
  jpa:
    hibernate:
      ddl-auto: validate

# Never commit secrets!
# .gitignore includes:
application-prod.yml
*.key
*.pem
.env
```

---

## 📊 Performance Standards

### Response Time Targets
- GET single resource: < 100ms
- GET list/paginated: < 500ms
- POST/PUT: < 200ms
- DELETE: < 150ms

### Database Query Optimization
- Use indexes for frequently queried fields
- Avoid N+1 queries (use JOIN FETCH or projections)
- Cache frequently accessed data
- Monitor slow queries with logs

### Caching Strategy
- Cache TTL: 10 minutes for most data
- Invalidate cache on create/update
- Use cache headers in API responses
- Implement cache hit ratios monitoring

### Load Testing
Minimum performance targets:
- 1000 concurrent users
- 99th percentile latency < 1000ms
- No errors under normal load
- Graceful degradation under stress

---

## 📈 Monitoring & Logging

### Log Levels
- **ERROR**: Fatal errors requiring immediate attention
- **WARN**: Warnings that don't prevent operation
- **INFO**: Important business events and state changes
- **DEBUG**: Detailed diagnostic information
- **TRACE**: Very detailed debugging (disabled in production)

### Structured Logging
```java
// Good: Structured logging with context
logger.info("Product created successfully",
    Map.of(
        "productId", productId,
        "productName", name,
        "price", price,
        "userId", userId,
        "timestamp", System.currentTimeMillis()
    ));

// Bad: Unstructured logging
logger.info("Product created: " + id + " - " + name);
```

### Key Metrics to Monitor
- Request rate (req/sec)
- Error rate (errors/sec)
- Response time (p50, p95, p99)
- Database connection pool usage
- Cache hit ratio
- Thread pool utilization
- Memory usage
- GC pause times

---

## 📆 Sprint & Deadline Management

### Daily Targets
- **6.5 hours** active coding/study time
- **At least 1 code exercise** completed
- **Daily reflection** submitted
- **Code review** of 1 peer's code
- **1-2 meaningful commits** to Git

### Weekly Targets
- **Complete all daily goals** (5 days minimum)
- **Module progress**: 14% of 30-day module complete
- **All code reviewed** by at least 2 peers
- **Weekly report** submitted Friday
- **No technical debt** should be accumulated

### Module Completion Checklist
- [ ] All study materials reviewed
- [ ] All exercises completed
- [ ] All tests passing (>80% coverage)
- [ ] Code reviewed and approved
- [ ] Documentation complete
- [ ] Performance benchmarks analyzed
- [ ] Final project delivered
- [ ] Peer evaluation completed

---

## 🚨 Escalation & Support

### Issue Resolution Timeline
1. **Immediate**: Critical production bugs (escalate within 1 hour)
2. **High**: Major features broken (escalate within 4 hours)
3. **Medium**: Minor bugs, performance issues (escalate within 1 day)
4. **Low**: Documentation, nice-to-have features (escalate within 3 days)

### How to Request Help
1. Spend 30 minutes debugging yourself
2. Post detailed question in team chat
3. Include: error message, code snippet, what you've tried
4. If not resolved in 1 hour, escalate to team standup
5. If not resolved by EOD, book 30-min help session

### When to Escalate to Instructor
- Conceptual gap (don't understand topic after reading)
- Curriculum-specific questions
- Architectural decisions (multiple valid approaches)
- Production issues that team can't resolve

---

## 🎓 Learning & Knowledge Sharing

### Knowledge Sharing Sessions
- **Duration**: 15-30 minutes
- **Frequency**: Optional, ad-hoc
- **Topics**: New techniques, solutions to interesting problems
- **Format**: Live coding demo or presentation

### Recommended Topics
- Performance optimization techniques
- Testing strategies for complex scenarios
- Security best practices
- System design patterns
- Cloud deployment techniques

### Code Review as Learning
- Take time to understand others' code
- Ask questions if something is unclear
- Suggest better approaches when appropriate
- Share relevant resources and articles

---

## ✅ Acceptance Criteria Template

Use this template for evaluating completed work:

```markdown
## Feature Acceptance Criteria

- [ ] Code is clean and follows team standards
- [ ] All tests pass (unit, integration, E2E)
- [ ] Code coverage >= 80%
- [ ] No performance regressions
- [ ] Documentation is complete and accurate
- [ ] API documentation updated (if applicable)
- [ ] No security vulnerabilities
- [ ] Peer code review approved
- [ ] No technical debt introduced
- [ ] Backward compatibility maintained (if applicable)
- [ ] Deployment steps documented
- [ ] Rollback plan prepared (if applicable)
```

---

## 📞 Contact & Escalation

**Team Lead**: Kenneth (kenneth@shopflow.dev)
**C++ Lead**: Developer 2 (dev2@shopflow.dev)
**C++ Lead**: Developer 3 (dev3@shopflow.dev)

**Response Times**:
- **Critical Issues**: 30 minutes
- **High Priority**: 2 hours
- **Medium Priority**: 4 hours
- **Low Priority**: 1 business day

---

**Last Updated**: August 6, 2026
**Version**: 1.0
**Next Review**: End of Module 0

