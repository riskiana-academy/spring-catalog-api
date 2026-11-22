# 📋 WEEK 10 Lab - Student Checklist

**Name:** ________________________  
**Date:** ________________________  
**Group/Individual:** ____________

---

## ✅ Phase 1: Setup & Configuration (10 minutes)

### Database Setup
- [ ] MySQL Server is running
- [ ] Database `catalog_db` created
- [ ] Can connect to database

### Project Setup
- [ ] Downloaded/cloned starter template
- [ ] Updated `application.properties` with correct DB credentials
- [ ] Ran `mvn clean install` successfully
- [ ] No compilation errors in IDE

### Application Running
- [ ] Application starts without errors
- [ ] Console shows: "Tomcat started on port(s): 8080"
- [ ] No red error messages in console
- [ ] Can access `http://localhost:8080` (or see startup messages)

---

## ✅ Phase 2: Understanding the Code (20 minutes)

### File Exploration
- [ ] Read through **README.md**
- [ ] Read through **QUICK_START.md**
- [ ] Skimmed **LAB_GUIDE.md** for reference

### Code Review
- [ ] Examined `ProductController.java` - understand endpoints
- [ ] Examined `ProductCreateRequest.java` - understand validation
- [ ] Examined `ProductService.java` - understand Optional + Lambda
- [ ] Examined `GlobalExceptionHandler.java` - understand error handling
- [ ] Examined `AuthController.java` + `JwtUtils.java` - understand JWT

### Concepts Understanding
- [ ] Can explain what `@Valid` does
- [ ] Can explain what `@NotBlank` does
- [ ] Can explain Optional + `.orElseThrow()` pattern
- [ ] Can explain what `@RestControllerAdvice` does
- [ ] Can explain JWT concept (token-based auth)

---

## ✅ Phase 3: Testing API Endpoints (30 minutes)

### Authentication Endpoint
- [ ] POST `/api/auth/login` with valid credentials
  - Expected: 200 OK with token
  - Actual: _______________
- [ ] Copy token from response
- [ ] Save token for next tests

### GET Endpoints - Success Cases
- [ ] GET `/api/products` (empty list initially)
  - Expected: 200 OK, empty array `[]`
  - Actual: _______________
  
### POST Endpoints - Valid Data
- [ ] POST `/api/products` with valid data:
  ```json
  {
    "id": "PROD001",
    "name": "Laptop Gaming ASUS",
    "price": 15000000.0
  }
  ```
  - Expected: 201 Created, product returned
  - Actual: _______________

- [ ] GET `/api/products` again
  - Expected: 200 OK, array dengan 1 product
  - Actual: _______________

- [ ] GET `/api/products/PROD001`
  - Expected: 200 OK, product detail
  - Actual: _______________

### POST Endpoints - Validation Errors
- [ ] POST with empty `id`:
  - Expected: 400 Bad Request, error message
  - Actual error message: _______________

- [ ] POST with empty `name`:
  - Expected: 400 Bad Request, error message
  - Actual error message: _______________

- [ ] POST with `price` = 500 (too low):
  - Expected: 400 Bad Request, error message
  - Actual error message: _______________

- [ ] POST with ALL fields invalid:
  - Expected: 400 Bad Request, multiple error messages
  - Actual: _______________

### GET Endpoints - Not Found Cases
- [ ] GET `/api/products/INVALID_ID`
  - Expected: 404 Not Found, error message
  - Actual error message: _______________

---

## ✅ Phase 4: Code Modification Tasks (Optional/Bonus)

### Task 1: Add More Products
- [ ] Create 3-5 more products via API
- [ ] Verify they appear in GET `/api/products`

### Task 2: Modify Validation Rules
- [ ] Add `@Max` validation to price (e.g., max 1 billion)
- [ ] Add `@Size` validation to name (e.g., 3-100 characters)
- [ ] Test new validation rules
- [ ] File modified: _______________

### Task 3: Add More Fields to Product
- [ ] Add new field (e.g., `description`, `category`, `stock`)
- [ ] Add corresponding field to `ProductCreateRequest.java`
- [ ] Update database table (via ddl-auto=update)
- [ ] Test creation with new field
- [ ] Fields added: _______________

### Task 4: Enhance Exception Handling
- [ ] Add handler for custom business exception
- [ ] Implement specific error message for edge cases
- [ ] Example: _______________

### Task 5: Implement Additional Endpoint (Bonus)
- [ ] Implement PUT `/api/products/{id}` (update)
- [ ] Implement DELETE `/api/products/{id}` (delete)
- [ ] Test both endpoints
- [ ] Screenshot of working DELETE: _______________

---

## ✅ Phase 5: Testing Evidence

### Screenshots/Evidence Needed
- [ ] Screenshot: Application running on port 8080
  
- [ ] Screenshot: Postman/Insomnia login request (200 OK)
  
- [ ] Screenshot: Create product request (201 Created)
  
- [ ] Screenshot: Create with validation error (400 Bad Request)
  
- [ ] Screenshot: Get not found error (404 Not Found)

---

## 📊 Self-Assessment

### Understanding Level (1=Poor, 5=Excellent)
- Input Validation (@Valid, @NotBlank): _____ / 5
- Global Exception Handling: _____ / 5
- Optional + Lambda (Java 8): _____ / 5
- JWT Authentication: _____ / 5
- REST API Design: _____ / 5

### Confidence Level
- Can run this project independently: _____ / 5
- Can create similar project from scratch: _____ / 5
- Can explain concepts to someone else: _____ / 5

---

## ❓ Questions & Notes

**Questions I have:**
1. _______________________________________________
2. _______________________________________________
3. _______________________________________________

**Things I found interesting:**
1. _______________________________________________
2. _______________________________________________

**Things I need more help with:**
1. _______________________________________________
2. _______________________________________________

---

## 🎓 Learning Summary

**What I learned today:**
- _______________________________________________
- _______________________________________________
- _______________________________________________

**How this will be useful:**
- _______________________________________________
- _______________________________________________

**Next steps for deeper learning:**
- [ ] Read Spring Security documentation
- [ ] Implement JWT token verification filter
- [ ] Add database migrations (Flyway)
- [ ] Write unit tests with JUnit + Mockito
- [ ] Deploy to cloud (Heroku/AWS)

---

## ✨ Final Checklist

### Must Complete
- [ ] All Phase 1 items checked
- [ ] All Phase 2 items checked
- [ ] All Phase 3 items checked (minimum)
- [ ] All API endpoints tested successfully
- [ ] No errors/exceptions in application

### Should Complete
- [ ] At least 2 bonus tasks from Phase 4
- [ ] All screenshots captured
- [ ] Self-assessment completed
- [ ] Questions documented

### Nice to Have
- [ ] All Phase 4 bonus tasks completed
- [ ] Additional enhancements added
- [ ] Code comments added for clarity
- [ ] Project deployed somewhere

---

## 📝 Submission Notes

**Files to submit:**
- [ ] Modified source code (if any changes)
- [ ] Screenshots of test results
- [ ] Completed checklist (this file)
- [ ] README/notes explaining your modifications

**How to submit:**
1. Zip your project folder
2. Include filled checklist
3. Add screenshot evidence
4. Submit via e-learning/GitHub

---

**Instructor Notes:**
_____________________________________________________________________________
_____________________________________________________________________________
_____________________________________________________________________________

---

**Completion Date:** ____________________

**Instructor Signature:** ____________________

**Grade:** ____ / 100

---

**Congratulations! You've completed Week 10 Lab! 🎉**
