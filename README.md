# Personal Knowledge Base

基于 Spring Boot + MyBatis + MySQL 构建的个人知识管理系统，支持知识记录、分类管理、搜索与文件上传。

---

##  技术栈

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

##  已实现功能

###  用户模块
- 用户注册
- 用户登录
- JWT 身份认证
- 用户数据隔离

---

###  知识模块
- 创建知识
- 修改知识
- 删除知识
- 查看知识详情
- 分类管理

---

###  查询功能
- 关键词搜索（多字段模糊查询）
- 分页查询

---

###  文件模块
- 文件上传（附件系统）

---

##  项目结构

采用经典 Spring Boot 分层架构：


Controller → Service → Mapper → MySQL


包结构：


controller
service
service.impl
mapper
entity
dto
vo
config
utils


---

##  API 模块划分

- `/auth` 登录注册
- `/user` 用户模块
- `/category` 分类管理
- `/knowledge` 知识管理
- `/attachment` 文件上传

---

## 📊 项目状态

当前版本：


v0.1.0 - MVP 后端功能完成


---

##  后续规划

- Markdown 编辑与渲染支持
- 标签系统（Tag）
- 收藏功能
- 全文检索优化（MySQL FULLTEXT / ES）
- 最近访问记录
- AI / RAG 知识问答扩展

---

##  架构说明

系统基于分层架构设计：


Controller → Service → Mapper → Database


通过 JWT 实现用户隔离，保证多用户数据安全性。

---

##  项目特点

- 轻量级知识管理后端
- 支持扩展为 RAG / AI 知识库
- 可作为 Spring Boot 实战项目模板
