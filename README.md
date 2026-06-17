# Personal Knowledge Base

基于 SpringBoot + MyBatis + MySQL 构建的个人知识管理系统。

## 技术栈

### 后端

- Java 17
- Spring Boot 3.5.15
- MyBatis
- MySQL 8.0
- JWT
- Maven

### 接口测试

- Swagger / OpenAPI

---

## 已实现功能

### 用户模块

- 用户注册
- 用户登录
- JWT身份认证
- 用户数据隔离

### 知识模块

- 创建知识
- 修改知识
- 删除知识
- 查看知识
- 分类管理

### 查询功能

- 关键词搜索
- 分页查询

---

## 项目结构
controller
service
mapper
entity
dto
vo
config
utils


采用经典 Spring Boot 分层架构：

Controller
↓
Service
↓
Mapper
↓
MySQL


---

## 后续规划

- 文件上传
- Markdown编辑器
- 标签系统
- 收藏功能
- 全文搜索优化
- AI/RAG知识问答
