# Personal Knowledge Base

基于 Spring Boot + MyBatis + MySQL 构建的个人知识管理系统，支持知识记录、分类管理、搜索与文件上传。

---

# 技术栈

## 后端

* Java 17
* Spring Boot 3.5.15
* MyBatis
* MySQL 8.0
* JWT
* Maven

## 接口测试

* Swagger / OpenAPI

---

# 已实现功能

## 用户模块

* 用户注册
* 用户登录
* JWT 身份认证
* 用户数据隔离

---

## 知识模块

* 创建知识
* 修改知识
* 删除知识
* 查看知识详情
* 分类管理
* 关键词搜索（多字段模糊查询）
* 分页查询

---

## 文件模块

* 文件上传（附件系统）
* 文件与知识点关联（knowledgeId）

### 当前实现说明

文件存储采用本地文件系统方案：

* 文件存储在项目运行目录 uploads/ 下
* 数据库仅保存文件元信息（路径、名称、大小等）
* 适用于学习与快速开发阶段

---

# 项目结构

采用经典 Spring Boot 分层架构：

```
Controller → Service → Mapper → MySQL
```

包结构：

```
controller
service
service.impl
mapper
entity
dto
vo
config
utils
```

---

# API 模块划分

| 模块          | 说明   |
| ----------- | ---- |
| /auth       | 登录注册 |
| /user       | 用户模块 |
| /category   | 分类管理 |
| /knowledge  | 知识管理 |
| /attachment | 文件上传 |

---

# 项目状态

当前版本：

```
v0.1.0 - MVP 后端功能完成
```

---

# 系统设计说明

## 文件上传系统

当前采用本地存储方案：

### 特点

* 实现简单
* 无外部依赖
* 适用于学习和快速开发

### 限制

* 依赖服务器磁盘
* 不支持分布式部署
* 存储与应用强耦合

---

## 搜索系统

当前实现：

* MySQL LIKE 模糊查询
* 多字段搜索（title / content / summary / tags）

### 后续优化方向

* MySQL FULLTEXT 索引
* Elasticsearch 全文检索
* 向量检索（语义搜索）

---

## 知识内容模型

当前支持字段：

* title
* content（支持 Markdown）
* summary
* tags
* contentType

---

# 后续规划

* Markdown 编辑与渲染支持
* 标签系统（Tag）
* 收藏功能
* 最近访问记录
* 全文检索优化（MySQL FULLTEXT / ES）
* AI / RAG 知识问答扩展
* 文件存储系统抽象化（Local / OSS / MinIO）

---

# 架构说明

系统基于标准分层架构：

```
Controller → Service → Mapper → Database
```

通过 JWT 实现用户隔离，保证多用户数据安全性。

---

# 项目特点

* 轻量级知识管理后端系统
* 支持 Markdown 知识内容扩展
* 可扩展为 AI / RAG 知识库系统
* 适合作为 Spring Boot 实战与面试项目模板
* 已具备基础工程结构（分层 + VO/DTO + JWT）

---

# 项目阶段定位

```
阶段1：CRUD系统（已完成）
阶段2：知识库系统（进行中）
阶段3：搜索增强（规划中）
阶段4：AI知识问答（RAG扩展）
