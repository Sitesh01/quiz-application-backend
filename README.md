# 📘 Quiz App Backend – REST API (Spring Boot + MySQL)

This is a backend REST API for an online quiz application.
It supports quiz creation, question management, submitting answers, and score evaluation.
Built using Spring Boot, JPA/Hibernate, and MySQL.

## 🚀 Features

✔ Create quizzes
✔ Add questions with multiple options
✔ Fetch all quizzes
✔ Fetch questions of a quiz
✔ Submit answers and receive a score
✔ Store user-selected answers for analytics
✔ Fully DTO-based clean architecture

## 🛠️ Tech Stack

- Java 21

- Spring Boot 3+

- Spring Web

- Spring Data JPA

- MySQL Database

- Lombok

- Hibernate ORM

## 📂 Project Structure
```
src/main/java/com/siteshkumar/quiz_app_backend
│
├── controller
│   ├── QuizController.java
│   ├── QuestionController.java
│   └── QuizAttemptController.java
│
├── service
│   ├── QuizService.java
│   ├── QuestionService.java
│   └── QuizAttemptService.java
│
├── service/impl
│   ├── QuizServiceImpl.java
│   ├── QuestionServiceImpl.java
│   └── QuizAttemptServiceImpl.java
│
├── entity
│   ├── QuizEntity.java
│   ├── QuestionEntity.java
│   ├── OptionEntity.java
│   └── UserAnswerEntity.java
│
├── dto
│   ├── QuizDTO.java
│   ├── QuestionDTO.java
│   ├── OptionDTO.java
│   ├── UserAnswerDTO.java
│   ├── SubmitScoreDTO.java
│   └── ScoreDTO.java
│
└── mapper
    ├── QuizMapper.java
    ├── QuestionMapper.java
    ├── OptionMapper.java
    └── UserAnswerMapper.java
```

## 📦 API Endpoints

Below is the full list of all available endpoints.

## 1️⃣ Get All Quizzes

GET
```
localhost:8080/api/v1/quizzes/all
```

Response
```
[
  {
    "quizId": 1,
    "title": "Java Basics",
    "questions": [...]
  }
]
```

## 2️⃣ Create a Quiz

POST
```
localhost:8080/api/v1/quizzes/create?title=Java Quiz
```

Response
```
true
```

## 3️⃣ Get All Questions for a Quiz

GET
```
localhost:8080/api/v1/questions/quiz/{quizId}
```

Example Response
```
[
  {
    "questionId": 10,
    "text": "What is Java?",
    "type": "MCQ",
    "options": [
      { "optionId": 100, "text": "Programming Language", "correct": true },
      { "optionId": 101, "text": "Coffee", "correct": false }
    ]
  }
]
```

## 4️⃣ Add a Question to a Quiz

POST
```
localhost:8080/api/v1/questions/add/{quizId}
```

Request Body
```
{
  "text": "What is Java?",
  "type": "MCQ",
  "options": [
    { "text": "Programming Language", "correct": true },
    { "text": "Coffee", "correct": false },
    { "text": "Animal", "correct": false }
  ]
}
```

Response
```
"Question added successfully!"
```

## 5️⃣ Submit Answers & Get Score

POST
```
localhost:8080/api/v1/quiz/submit
```

Request Body
```
{
  "quizId": 1,
  "answers": [
    { "questionId": 10, "selectedOptionId": 100 },
    { "questionId": 11, "selectedOptionId": 105 }
  ]
}
```

Example Response
```
{
  "score": 1,
  "total": 2
}
```

## 🛢️ Database Schema (Simplified)

Tables generated via Hibernate:

```
quizzes
questions
options
user_answers
```

Relationships:

- Quiz → Questions (One-To-Many)

- Question → Options (One-To-Many)

- Question → UserAnswers (One-To-Many)

- Option → UserAnswers (One-To-Many)

- Quiz → UserAnswers (One-To-Many)

## ▶️ How to Run the Project
### 1️⃣ Update application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_app
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 2️⃣ Build & Run

Using Maven:

```
mvn clean install
mvn spring-boot:run
```

App starts at:

👉 http://localhost:8080

## 🧪 Testing

- You can test using:

- Postman

- Thunder Client (VS Code)

- cURL

## 📌 Future Enhancements

- Add user authentication (JWT)

- Add quiz attempts table for multi-attempt tracking

- Add leaderboard ranking

- Add timer per quiz/question

- Add admin dashboard

## ❤️ Contributing

Pull requests are welcome!

## 📜 License

This project is open-source under the MIT License.

## 👋 Thank You!

Thank you for checking out this project!
If you find it helpful, feel free to ⭐ star the repository and follow for more exciting projects.

### Happy coding! 🚀
