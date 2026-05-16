# GMS - 学生课程管理系统

一个基于 Spring Boot 的学生与课程信息管理 Web 应用，支持对学生和课程数据进行增删改查操作，并带有分页功能和全局异常处理。

## 功能模块

### 学生管理
- 学生列表分页展示（每页 3 条）
- 添加学生信息（学号、姓名、性别、籍贯、专业号）
- 编辑学生信息
- 删除学生（AJAX 异步删除）

### 课程管理
- 课程列表分页展示（每页 3 条）
- 添加课程信息（课程号、课程名、学时）
- 编辑课程信息
- 删除课程（AJAX 异步删除）

### 首页导航
- 提供学生管理和课程管理的入口

## 技术栈

| 分类       | 技术                        | 版本    |
| ---------- | --------------------------- | ------- |
| 基础框架   | Spring Boot                 | 4.0.6   |
| MVC 框架   | Spring WebMVC               | -       |
| 模板引擎   | Thymeleaf                   | -       |
| ORM 框架   | MyBatis                     | 4.0.1   |
| 分页插件   | PageHelper                  | 2.1.1   |
| 数据库     | MySQL                       | -       |
| JDBC 驱动  | MySQL Connector/J           | -       |
| 前端库     | jQuery                      | 3.7.1   |
| 简化代码   | Lombok                      | -       |
| 开发工具   | Spring Boot DevTools        | -       |
| Java 版本  | JDK 17                      | -       |
| 构建工具   | Maven                       | -       |

## 项目结构

```
src/main/java/com/javaee/gms_ex/
├── GmsExApplication.java          # Spring Boot 启动类
├── controller/
│   ├── StudentController.java     # 学生管理控制器
│   └── CourseController.java      # 课程管理控制器
├── service/
│   ├── StudentService.java        # 学生服务接口
│   ├── CourseService.java         # 课程服务接口
│   └── impl/
│       ├── StudentServiceImpl.java
│       └── CourseServiceImpl.java
├── mapper/
│   ├── StudentMapper.java         # 学生 Mapper 接口
│   └── CourseMapper.java          # 课程 Mapper 接口
├── po/
│   ├── Student.java               # 学生实体类
│   └── Course.java                # 课程实体类
└── handler/
    └── GlobalExceptionHandler.java # 全局异常处理器

src/main/resources/
├── application.properties         # 应用配置文件
├── mapper/
│   ├── StudentMapper.xml          # 学生 SQL 映射
│   └── CourseMapper.xml           # 课程 SQL 映射
├── templates/
│   ├── index.html                 # 首页
│   ├── student/
│   │   ├── studentlist.html       # 学生列表页
│   │   └── add_student.html       # 添加/编辑学生页
│   └── course/
│       ├── courselist.html        # 课程列表页
│       └── add_course.html        # 添加/编辑课程页
└── static/js/
    └── jquery-3.7.1.min.js        # jQuery 库
```

## 架构说明

项目采用经典的三层架构：

- **Controller 层** — 处理 HTTP 请求，返回 Thymeleaf 视图或 JSON 数据
- **Service 层** — 业务逻辑处理，使用 `@Transactional` 管理事务
- **Mapper 层** — 通过 MyBatis XML 映射文件与 MySQL 数据库交互

分页使用 PageHelper 分页插件实现，前端通过 Thymeleaf 模板渲染，删除操作使用 jQuery AJAX 异步提交。

## 数据库

需要 MySQL 数据库，默认连接信息如下（可在 `application.properties` 中修改）：

- 数据库名：`student`
- 用户名：`root`
- 密码：`123456`

### 数据表结构

**stu 表（学生）**

| 字段名  | 类型         | 说明   |
| ------- | ------------ | ------ |
| sno     | VARCHAR      | 学号（主键） |
| sname   | VARCHAR      | 姓名   |
| ssex    | VARCHAR      | 性别   |
| snative | VARCHAR      | 籍贯   |
| mno     | INT          | 专业号 |

**course 表（课程）**

| 字段名 | 类型         | 说明     |
| ------ | ------------ | -------- |
| cno    | INT          | 课程号（主键） |
| cname  | VARCHAR      | 课程名   |
| period | INT          | 学时     |

## 启动方式

1. 确保已安装 JDK 17 和 Maven
2. 创建 MySQL 数据库 `student`，并建好 `stu` 和 `course` 表
3. 修改 `application.properties` 中的数据库连接信息
4. 在项目根目录执行：

```bash
./mvnw spring-boot:run
```

5. 访问 http://localhost:8080
