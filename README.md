🍃 [Mini-Farm（扶农助农平台服务端的设计与实现)](https://ukkhp7b2c4.feishu.cn/docx/R4xcdE0YhoUdz0xbDzicByhPnoh)
========================================
> Mini-Farm是一款互联网面向C端人群的扶农助农小程序，可以提供农产品展示、分类筛选、农户扶贫申请、扶农助农资讯、购物车、农产品推荐、在线结算、订单发货、农产品收藏、用户评论等功能。亦在为广大农户提供一个健康可持续的销售渠道，促进农户农产品的销售，做到扶贫助农。

## 🧑‍💻 项目列表

|    项目      | 描述                            | 
| ----------- | ------------------------------- 
| 扶农助农平台服务端的设计与实现  | 提供农产品推荐、展示、购买、下单等领域功能，以分布式部署的方式提供支持。    |
| C端用户小程序                | 方便微信用户查看、购买农产品等的日常使用        |
| B端用户管理系统              | 满足管理员对于农产品、农户等的查询、配置、修改、审核等操作   |

## 💻 服务端工程列表(Mini-Farm-Server)

| 工程项目      | 描述                            | 
| ----------- | ------------------------------- 
| Mini-Farm-Cart         | 购物车模块      |
| Mini-Farm-Coupon       | 优惠卷模块      |
| Mini-Farm-Message      | 消息模块        |
| Mini-Farm-Order        | 订单模块        |
| Mini-Farm-Pay          | 支付模块        |
| Mini-Farm-Product      | 产品模块        |
| Mini-Farm-User         | 用户模块        |

## 📐 开发规范

**分支命名**：日期_姓名首字母缩写_功能单词，如：`210804_atao_buildFramework`

**提交规范**：type (scope) : desc 如：`fix(service)：修复查询用户信息逻辑问题` *参考Commit message 规范*

## 🔀 相关技术

**涉及技术**：SpringBoot、Mybatis-Plus、SpringCloud Alibaba、SpringCloud Gateway、MQ、Redis、MySQL、ElasticSearch、XXL-Job等

## ⚔ 环境配置

**开发环境**：

- MySQL 8.0+
- Nacos 2.1+
- Sentinel 1.8+
- RocketMQ 4.5+
- 其它：根据项目pom依赖版本而定
- 待定

## 🕌 项目架构

**项目架构**：待定

## 📄 参考文献

**相关文献**：待定

## 📘 开发日志
- [x] 【 2023-01-09：搭建项目初始工程 】
- [x] 【 2023-01-10：构建项目基础组件：分布式id生成、MP抽取公共逻辑、AOP日志打印 】
- [x] 【 2023-01-11：构建项目基础组件：抽取web全局异常处理、抽取swagger文档处理、梳理信息服务流程 】
- [x] 【 2023-01-12：熟悉用户服务功能点与流程 】
- [x] 【 2023-01-13：梳理用户登录流程功能、收货地址列表 】
- [x] 【 2023-01-15：测试邮件发送功能、引入nacos统一配置服务管理 】
- [x] 【 2023-01-18：搭建RocketMQ环境、引入MQ异步发送邮件信息 】
- [x] 【 2023-01-30：梳理商品服务业务 】
- [x] 【 2023-01-31：简单测试商品服务环境，修复nacos配置获取不到的情况，梳理购物车业务】
- [x] 【 2023-02-03：完成用户收货地址相关的基础逻辑】
