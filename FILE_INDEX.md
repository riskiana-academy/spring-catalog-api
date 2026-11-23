# 📚 Week 10 Starter Template - File Index

**Last Updated:** November 22, 2026  
**Status:** ✅ Ready for Distribution

---

## 📖 Documentation Guide (Start Here!)

### For Students 👨‍💻👩‍💻

1. **[QUICK_START.md](./QUICK_START.md)** ⚡ START HERE!
   - 5-minute setup guide
   - Database configuration (AUTO-CREATE! ✨)
   - Run your first test
   - Common issues & fixes
   - **Read this first!**

2. **[README.md](./README.md)** 📖
   - Complete project documentation
   - Project structure explanation
   - API endpoint documentation
   - Feature descriptions
   - Testing guide with Postman

3. **[LAB_GUIDE.md](./LAB_GUIDE.md)** 🧪
   - Detailed lab instructions (45 pages worth)
   - Concept explanations
   - Step-by-step coding walkthrough
   - Activity assignments
   - Troubleshooting section
   - Bonus challenges

4. **[STUDENT_CHECKLIST.md](./STUDENT_CHECKLIST.md)** ✅
   - Self-assessment checklist
   - Lab completion tracking
   - Understanding verification
   - Self-grading rubric

---

### For Instructors/Dosen 👨‍🏫👩‍🏫

1. **[TEMPLATE_SUMMARY.md](./TEMPLATE_SUMMARY.md)** 📋
   - Template overview
   - What's included & why
   - Teaching guidance
   - Customization options
   - Deployment notes

2. **[postman-collection.json](./postman-collection.json)** 🧪
   - Ready-to-import Postman collection
   - All test cases pre-configured
   - Save student's time
   - Just import & test!

---

## 🗂️ Project Structure

### Documentation Files (Read in This Order)
```
├── QUICK_START.md           ← Start here (5 min read)
├── README.md                ← Full documentation
├── LAB_GUIDE.md             ← Detailed instructions
├── TEMPLATE_SUMMARY.md      ← For instructors
├── STUDENT_CHECKLIST.md     ← For self-assessment
├── postman-collection.json  ← Postman test file
└── FILE_INDEX.md            ← This file
```

### Java Source Code
```
src/main/java/com/budiluhur/spring/catalog/api/
│
├── Application.java                        ← Main class
│
├── controller/
│   ├── AuthController.java                 ← Login endpoint
│   └── ProductController.java              ← Product endpoints
│
├── service/
│   └── ProductService.java                 ← Business logic
│
├── model/
│   └── Product.java                        ← JPA Entity
│
├── repository/
│   └── ProductRepository.java              ← Data access
│
├── dto/                                    ← Request/Response DTOs
│   ├── ProductCreateRequest.java           ← Validation rules here!
│   ├── LoginRequest.java
│   └── AuthResponse.java
│
├── exception/
│   ├── ResourceNotFoundException.java      ← Custom exception
│   └── GlobalExceptionHandler.java         ← Error handling
│
└── config/
    ├── JwtUtils.java                      ← Token generator
    └── SecurityConfig.java                ← Security settings
```

### Configuration Files
```
pom.xml                                    ← Maven dependencies
src/main/resources/
└── application.properties                 ← Database config
```

---

## 🔍 Quick Reference

### Where to Find...

**How to run the project?**
→ [QUICK_START.md](./QUICK_START.md) (Section: "Run Project")

**API endpoint documentation?**
→ [README.md](./README.md) (Section: "API Endpoints")

**Input validation examples?**
→ [LAB_GUIDE.md](./LAB_GUIDE.md) (Section: "PART 2: Input Validation")

**Global exception handling?**
→ [LAB_GUIDE.md](./LAB_GUIDE.md) (Section: "Exception Handling")

**Java 8 Optional + Lambda?**
→ [LAB_GUIDE.md](./LAB_GUIDE.md) (Section: "PART 3: Java 8 Optional")

**JWT authentication flow?**
→ [LAB_GUIDE.md](./LAB_GUIDE.md) (Section: "PART 4: JWT Authentication")

**Postman testing?**
→ [README.md](./README.md) (Section: "Testing dengan Postman")

**Troubleshooting?**
→ [LAB_GUIDE.md](./LAB_GUIDE.md) (Section: "Troubleshooting") or [QUICK_START.md](./QUICK_START.md) (Section: "Common Issues")

**Database configuration?**
→ [QUICK_START.md](./QUICK_START.md) (Section: "Database Setup")

**Code modifications?**
→ [TEMPLATE_SUMMARY.md](./TEMPLATE_SUMMARY.md) (Section: "Customization Options")

---

## 📊 Content Map

### Topics Covered

#### Input Validation
- **What:** Jakarta Bean Validation annotations
- **Files:** `ProductCreateRequest.java`
- **Learn:** `README.md` → `LAB_GUIDE.md` Part 1

#### Exception Handling
- **What:** @RestControllerAdvice, error responses
- **Files:** `GlobalExceptionHandler.java`
- **Learn:** `README.md` → `LAB_GUIDE.md` Part 1

#### Java 8 Essentials
- **What:** Optional<T>, Lambda expressions
- **Files:** `ProductService.java`
- **Learn:** `LAB_GUIDE.md` Part 2

#### JWT Authentication
- **What:** Token generation, stateless auth
- **Files:** `JwtUtils.java`, `AuthController.java`
- **Learn:** `LAB_GUIDE.md` Part 3

#### REST API Design
- **What:** Endpoints, HTTP methods, status codes
- **Files:** `ProductController.java`, `AuthController.java`
- **Learn:** `README.md` → API Endpoints

#### Spring Boot Architecture
- **What:** Layered architecture, dependency injection
- **Files:** All Java files
- **Learn:** `README.md` → Project Structure

---

## 🎯 Recommended Reading Path

### For First-Time Setup (Day 1)
1. [QUICK_START.md](./QUICK_START.md) - 5 minutes
2. Run project - 5 minutes
3. Test one endpoint - 5 minutes

### For Understanding (Day 1-2)
4. [README.md](./README.md) - 15 minutes
5. Explore source code - 20 minutes
6. Test all endpoints - 15 minutes

### For Deep Learning (Day 2-3)
7. [LAB_GUIDE.md](./LAB_GUIDE.md) PART 1 - 20 minutes
8. [LAB_GUIDE.md](./LAB_GUIDE.md) PART 2 - 15 minutes
9. [LAB_GUIDE.md](./LAB_GUIDE.md) PART 3 - 20 minutes

### For Practice (Day 3+)
10. Complete [STUDENT_CHECKLIST.md](./STUDENT_CHECKLIST.md)
11. Modify code as per bonus tasks
12. Add new features

---

## 📚 External Resources

### Learning Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jakarta Bean Validation](https://jakarta.ee/specifications/bean-validation/)
- [JWT Introduction](https://jwt.io/introduction)
- [Java 8 Streams & Optional](https://www.oracle.com/java/technologies/java8.html)

### Tools Needed
- **Java 21+** - Runtime environment
- **Maven** - Build tool (included in project)
- **MySQL 8.0+** - Database
- **Postman/Insomnia** - API testing

### IDE Recommendations
- VS Code (with Extension Pack for Java)
- IntelliJ IDEA (Community or Ultimate)
- Eclipse IDE

---

## ✅ Getting Started Checklist

Before starting, ensure you have:

- [ ] Java 21+ installed
- [ ] Maven installed
- [ ] MySQL installed and running
- [ ] Postman or similar API testing tool
- [ ] Text editor or IDE
- [ ] This project folder

**First action:** Open [QUICK_START.md](./QUICK_START.md)

---

## 🆘 Need Help?

**Problem:** Application won't start
→ [QUICK_START.md](./QUICK_START.md) - Section: "Common Issues"

**Problem:** Validation not working
→ [LAB_GUIDE.md](./LAB_GUIDE.md) - Section: "Part 1.1"

**Problem:** API endpoints returning 404
→ [README.md](./README.md) - Section: "API Endpoints"

**Problem:** JWT token not generated
→ [LAB_GUIDE.md](./LAB_GUIDE.md) - Section: "Part 3.3"

**Problem:** Database connection error
→ [QUICK_START.md](./QUICK_START.md) - Section: "Database Setup"

---

## 📝 File Statistics

| File | Size | Type | Audience |
|------|------|------|----------|
| QUICK_START.md | 7 KB | Guide | Students |
| README.md | 7.5 KB | Docs | Students/Instructors |
| LAB_GUIDE.md | 11 KB | Tutorial | Students |
| TEMPLATE_SUMMARY.md | 8.6 KB | Notes | Instructors |
| STUDENT_CHECKLIST.md | 7.7 KB | Checklist | Students |
| postman-collection.json | 8 KB | Test | Students/Instructors |
| FILE_INDEX.md | This file | Index | Everyone |

**Total Documentation:** ~50 KB

**Total Java Source:** ~20 KB (13 files)

**Total Project:** ~200 MB (with dependencies installed)

---

## 🎓 Key Learning Outcomes

After completing this starter template, students will understand:

✅ Input validation with @Valid and annotations  
✅ Global exception handling with @RestControllerAdvice  
✅ Java 8 Optional + Lambda expressions  
✅ JWT token generation and authentication  
✅ REST API design principles  
✅ Spring Boot layered architecture  
✅ Database interaction with JPA  
✅ Error handling best practices  

---

## 📌 Important Notes

### For Students
- **Don't skip the setup!** Follow [QUICK_START.md](./QUICK_START.md) exactly
- **Read error messages carefully** - they tell you what's wrong
- **Test all endpoints** using the checklist
- **Experiment!** Modify code and see what happens
- **Ask questions** if anything is unclear

### For Instructors
- **Customize as needed** - See [TEMPLATE_SUMMARY.md](./TEMPLATE_SUMMARY.md) Section: "Customization"
- **Share documentation selectively** - Don't overwhelm with all files at once
- **Use Postman collection** - Save time, focus on concepts
- **Walk through one example** - Then let students explore

---

## 🚀 Version Information

- **Template Version:** 1.0
- **Created:** November 22, 2026
- **Spring Boot Version:** 4.2.0
- **Java Version:** 21
- **Maven Version:** 3.9+
- **Status:** ✅ Production Ready

---

