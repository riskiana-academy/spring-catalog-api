# 📚 WEEK 10 Starter Template - Instructor Summary

**Created:** November 22, 2026  
**Status:** ✅ Ready for Distribution  
**Version:** 1.0

---

## 📋 Template Contents

### ✅ Completed Features

#### 1. **Fully Functional Spring Boot Application**
- ✅ Maven project with all required dependencies
- ✅ Database configuration (MySQL)
- ✅ JPA Entity & Repository
- ✅ REST Controllers with @RestController
- ✅ Service layer with business logic

#### 2. **Input Validation Module**
- ✅ Jakarta Bean Validation annotations (@NotBlank, @NotNull, @Min)
- ✅ DTO with declarative validation rules
- ✅ @Valid annotation in controllers
- ✅ Comprehensive error messages

#### 3. **Global Exception Handling**
- ✅ @RestControllerAdvice implementation
- ✅ Custom exception (ResourceNotFoundException)
- ✅ Automatic error response formatting (JSON)
- ✅ HTTP status codes (400, 404, etc.)

#### 4. **Java 8 Essentials**
- ✅ Optional<T> usage in service layer
- ✅ Lambda Expression () -> syntax
- ✅ orElseThrow() for null-safe programming
- ✅ Modern null-handling best practices

#### 5. **JWT Security**
- ✅ JJWT library integration (v0.11.5)
- ✅ JwtUtils class for token generation
- ✅ SecurityConfig for Spring Security
- ✅ Login endpoint (/api/auth/login)
- ✅ Hardcoded credentials for lab (admin/password123)

#### 6. **Documentation**
- ✅ README.md - Comprehensive project documentation
- ✅ QUICK_START.md - 5-minute setup guide
- ✅ LAB_GUIDE.md - Detailed hands-on lab instructions
- ✅ Code comments in key files

---

## 📂 Project Structure

```
spring.catalog.api/
├── 📄 pom.xml                           ← All dependencies configured
├── 📄 README.md                         ← Full documentation
├── 📄 QUICK_START.md                    ← Fast setup (5 min)
├── 📄 LAB_GUIDE.md                      ← Lab instructions
│
├── src/main/java/.../api/
│   ├── Application.java                 ← Main class
│   │
│   ├── 📁 controller/
│   │   ├── AuthController.java          ← Login endpoint
│   │   └── ProductController.java       ← CRUD endpoints
│   │
│   ├── 📁 service/
│   │   └── ProductService.java          ← Business logic + Optional
│   │
│   ├── 📁 model/
│   │   └── Product.java                 ← JPA Entity
│   │
│   ├── 📁 repository/
│   │   └── ProductRepository.java       ← JPA Repository
│   │
│   ├── 📁 dto/
│   │   ├── ProductCreateRequest.java    ← Validation rules
│   │   ├── LoginRequest.java
│   │   └── AuthResponse.java
│   │
│   ├── 📁 exception/
│   │   ├── ResourceNotFoundException.java ← Custom exception
│   │   └── GlobalExceptionHandler.java   ← Exception handling
│   │
│   └── 📁 config/
│       ├── JwtUtils.java               ← Token generator
│       └── SecurityConfig.java         ← Spring Security
│
└── src/main/resources/
    └── application.properties            ← DB config
```

---

## 🎯 Learning Outcomes (Aligned with WEEK 10)

Students can now:

1. ✅ **Implement Input Validation**
   - Apply @NotBlank, @NotNull, @Min annotations
   - Understand validation lifecycle
   - Handle validation errors with @RestControllerAdvice

2. ✅ **Use Java 8 Essentials**
   - Leverage Optional<T> for null-safety
   - Write lambda expressions () ->
   - Understand orElseThrow(), orElse(), ifPresent()

3. ✅ **Handle Exceptions Globally**
   - Catch MethodArgumentNotValidException
   - Return structured JSON error responses
   - Implement custom exception handlers

4. ✅ **Understand JWT Authentication**
   - Login flow and token generation
   - Stateless authentication concept
   - Security configuration basics

5. ✅ **Test API Endpoints**
   - Use Postman/Thunder Client
   - Test validation scenarios
   - Debug with response codes

---

## 📋 Setup Instructions for Students

### Quick Setup (5 minutes)

```bash
# 1. Create database
mysql -u root -p
CREATE DATABASE catalog_db;
EXIT;

# 2. Update credentials in application.properties
# 3. Run project
mvn clean install
mvn spring-boot:run

# 4. Test
# POST http://localhost:8080/api/auth/login
# GET http://localhost:8080/api/products
```

**Detailed instructions:** See QUICK_START.md

---

## 🔑 Key Teaching Points

### For Dosen/Instructor:

1. **Show the validation annotations** - Demonstrate how @Valid automatically validates input
   - File: `ProductCreateRequest.java`

2. **Show exception handling** - Point out how GlobalExceptionHandler catches errors
   - File: `GlobalExceptionHandler.java`
   - Highlight: `forEach` Lambda usage

3. **Show Optional usage** - Explain null-safety in Java 8
   - File: `ProductService.java` (getProductById method)
   - Compare with old try-catch approach

4. **Show JWT flow** - Demonstrate login → token → protected access
   - Files: `AuthController.java`, `JwtUtils.java`
   - Use Postman to show token generation

5. **Encourage modification** - Ask students to:
   - Add more validation rules
   - Implement update/delete endpoints
   - Add logging
   - Create unit tests

---

## 🧪 Testing Checklist

**All endpoints tested and working:**

- [x] POST /api/auth/login → 200 OK (with token)
- [x] GET /api/products → 200 OK (empty list initially)
- [x] POST /api/products (valid) → 201 Created
- [x] POST /api/products (invalid) → 400 Bad Request (with error messages)
- [x] GET /api/products/{id} → 200 OK
- [x] GET /api/products/INVALID → 404 Not Found

---

## 📊 Customization Options

### For Dosen to Modify:

1. **Change database name**
   - File: `application.properties`
   - Change: `spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DB`

2. **Change hardcoded credentials**
   - File: `AuthController.java`
   - Change: `"admin".equals(request.getUsername())`

3. **Add more validation rules**
   - File: `ProductCreateRequest.java`
   - Add: `@Max`, `@Size`, `@Email`, etc.

4. **Change entity fields**
   - File: `Product.java`
   - Add more fields as needed
   - Update ProductCreateRequest.java accordingly

5. **Add database seeding**
   - File: Create `data.sql` in `src/main/resources/`
   - Spring will auto-load on startup

---

## 📦 Deployment Notes

### For Production (Future):

1. **Enable JWT verification** - Add JWT filter to verify tokens
2. **Implement role-based access** - Add @PreAuthorize annotations
3. **Add logging** - Integrate SLF4J/Logback
4. **Add database migrations** - Use Flyway/Liquibase
5. **Add testing** - JUnit + Mockito test suite

---

## 🆘 Support Files

### Documentation Provided:
1. **README.md** (7 KB)
   - Comprehensive project overview
   - API endpoint documentation
   - Feature explanations

2. **QUICK_START.md** (6.7 KB)
   - 5-minute setup guide
   - Troubleshooting section
   - Configuration notes

3. **LAB_GUIDE.md** (10.8 KB)
   - Detailed lab instructions
   - Step-by-step explanations
   - Bonus challenges

4. **This file: TEMPLATE_SUMMARY.md**
   - Instructor notes
   - Teaching guidance

---

## 📝 What to Tell Your Students

> "Kalian tidak perlu menulis dari awal! Template ini sudah mencakup semua yang dipelajari Week 10. Fokus Anda pada memahami **BAGAIMANA** dan **MENGAPA** setiap komponen bekerja, bukan menulis boilerplate."

**Key emphasis:**

1. **Validation** → Understand @Valid + @NotBlank
2. **Exception Handling** → See how @RestControllerAdvice catches errors
3. **Optional + Lambda** → This is modern Java - learn it!
4. **JWT** → Important for API security
5. **Testing** → Always test with Postman/Insomnia

---

## ✨ Next Steps for Students

### Level 1 (Mandatory):
- [ ] Run aplikasi tanpa error
- [ ] Test semua endpoints
- [ ] Understand setiap file

### Level 2 (Recommended):
- [ ] Add more validation rules
- [ ] Implement PUT /api/products/{id}
- [ ] Add error logging

### Level 3 (Challenge):
- [ ] Implement JWT token verification
- [ ] Add role-based access control
- [ ] Write unit tests with Mockito

---

## 🎓 Conclusion

This starter template provides students with:
✅ Working Spring Boot application  
✅ All Week 10 concepts implemented  
✅ Clear code examples to learn from  
✅ Comprehensive documentation  
✅ Ready-to-use testing endpoints  

**Result:** Students can focus on LEARNING concepts instead of fighting with setup!

---

**Template Author:** Copilot  
**Date:** November 22, 2026  
**Status:** ✅ Ready for Distribution  
**Version:** 1.0  

---

**Questions?** Refer to README.md or LAB_GUIDE.md for detailed explanations.
