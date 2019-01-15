/*
 Navicat Premium Data Transfer

 Source Server         : sportsbenpeng
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : comment

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 15/01/2019 11:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `img_file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片文件名',
  `link` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `weight` int(11) NULL DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES (1, '暑假5折', '1495353501938_ad_1.png', 'http://www.imooc.com/wap/index', 6);
INSERT INTO `ad` VALUES (2, '特价出国', '1495353568008_ad_2.png', 'http://www.imooc.com/wap/index', 5);
INSERT INTO `ad` VALUES (3, '亮亮车', '1495353623949_ad_3.png', 'http://www.imooc.com/wap/index', 4);
INSERT INTO `ad` VALUES (4, '学钢琴', '1495353664627_ad_4.png', 'http://www.imooc.com/wap/index', 3);
INSERT INTO `ad` VALUES (5, '电影', '1495353700766_ad_5.png', 'http://www.imooc.com/wap/index', 2);
INSERT INTO `ad` VALUES (6, '旅游热线', '1495353735839_ad_6.png', 'http://www.imooc.com/wap/index', 1);

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `img_file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片文件名',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `price` decimal(11, 2) NULL DEFAULT NULL COMMENT '价格(单位：元)',
  `distance` int(11) NULL DEFAULT NULL COMMENT '距离(单位：米)',
  `number` int(11) NULL DEFAULT NULL COMMENT '已售数量',
  `desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `city` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `category` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别',
  `star_total_num` int(11) NULL DEFAULT NULL COMMENT '评论星星总数',
  `comment_total_num` int(11) NULL DEFAULT NULL COMMENT '评论总次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, '1495354718489_business_1.png', '汉堡大大', '叫我汉堡大大，还你多彩口味', 28.00, 120, 0, '1、当图片在app上不显示时，请查看system.properties里的访问路径，保存路径，如果看懂了视频：\r\n应该知道这个配置文件里的参数怎么改、我给你们的图片放在哪就可以了。<br/>2、后台管理用户名密码：admin/admin<br/>3、如果出现“没有权限访问请求资源，请切换账户后重试！”，请不要着急，先把applicationContext-web.xml中关于AuthInterceptor拦截器部分注释掉，等把拦截器听懂再来看看怎么回事！', '北京', 'meishi', 0, 0);
INSERT INTO `business` VALUES (2, NULL, '123', '1231', NULL, NULL, NULL, NULL, '北京', 'meishi', NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orders_id` int(11) NULL DEFAULT NULL COMMENT '用户名',
  `comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `star` int(1) NULL DEFAULT NULL COMMENT '星级评分',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Normal_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '1', 1, '2018-12-19 18:13:19');
INSERT INTO `comment` VALUES (2, 1, '2', 2, '2018-12-18 18:13:29');
INSERT INTO `comment` VALUES (3, 1, '3', 3, '2018-12-04 18:13:38');

-- ----------------------------
-- Table structure for dic
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic`  (
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`type`, `code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dic
-- ----------------------------
INSERT INTO `dic` VALUES ('category', 'jiehun', '结婚', 4);
INSERT INTO `dic` VALUES ('category', 'jingdian', '景点', 1);
INSERT INTO `dic` VALUES ('category', 'ktv', 'KTV', 2);
INSERT INTO `dic` VALUES ('category', 'meishi', '美食', 3);
INSERT INTO `dic` VALUES ('city', '上海', '上海', 2);
INSERT INTO `dic` VALUES ('city', '北京', '北京', 1);
INSERT INTO `dic` VALUES ('city', '广州', '广州', 3);
INSERT INTO `dic` VALUES ('httpMethod', 'DELETE', 'DELETE', 2);
INSERT INTO `dic` VALUES ('httpMethod', 'GET', 'GET', 4);
INSERT INTO `dic` VALUES ('httpMethod', 'POST', 'POST', 1);
INSERT INTO `dic` VALUES ('httpMethod', 'PUT', 'PUT', 3);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` bigint(13) NULL DEFAULT NULL COMMENT '手机号',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_unique`(`phone`) USING BTREE,
  UNIQUE INDEX `name_unique`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 13912345678, NULL, NULL);
INSERT INTO `member` VALUES (2, 13912345675, NULL, NULL);
INSERT INTO `member` VALUES (3, 13912345978, NULL, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_id` int(11) NULL DEFAULT NULL COMMENT '商户主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员主键',
  `num` int(11) NULL DEFAULT NULL COMMENT '消费人数',
  `comment_state` int(1) NULL DEFAULT NULL COMMENT '评论状态 -- 0：未评论 2：已评论',
  `price` decimal(11, 2) NULL DEFAULT NULL COMMENT '价格(消费金额)',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 1, 1, 2, 5.00, '2018-11-27 18:16:56');
INSERT INTO `orders` VALUES (2, 1, 1, 2, 2, 10.00, '2018-12-29 18:16:59');
INSERT INTO `orders` VALUES (3, 1, 1, 3, 2, 50.00, '2018-12-06 18:17:03');

-- ----------------------------
-- Table structure for sys_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_action`;
CREATE TABLE `sys_action`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动作名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动作地址',
  `menu_id` int(11) NULL DEFAULT NULL,
  `method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统表-操作表，权限拦截用，存放系统里全部动作。' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_action
-- ----------------------------
INSERT INTO `sys_action` VALUES (1, '浏览', '/auth', 2, '');
INSERT INTO `sys_action` VALUES (2, '浏览用户', '/users', 2, '');
INSERT INTO `sys_action` VALUES (3, '维护用户', '/users/.{1,}', 2, '');
INSERT INTO `sys_action` VALUES (4, '浏览用户组', '/groups', 2, '');
INSERT INTO `sys_action` VALUES (5, '维护用户组', '/groups/.{1,}', 2, '');
INSERT INTO `sys_action` VALUES (6, '分配菜单', '/groups/.{1,}/menus', 2, '');
INSERT INTO `sys_action` VALUES (7, '浏览菜单', '/menus', 2, '');
INSERT INTO `sys_action` VALUES (8, '维护菜单', '/menus/.{1,}', 2, '');
INSERT INTO `sys_action` VALUES (9, '菜单排序', '/menus/.{1,}/.{1,}/.{1,}', 2, '');
INSERT INTO `sys_action` VALUES (10, '浏览动作', '/actions', 2, '');
INSERT INTO `sys_action` VALUES (11, '维护动作', '/actions/.{1,}', 2, '');
INSERT INTO `sys_action` VALUES (12, '浏览', '/ad', 4, '');
INSERT INTO `sys_action` VALUES (13, '查询', '/ad/search', 4, '');
INSERT INTO `sys_action` VALUES (14, '删除', '/ad/remove', 4, '');
INSERT INTO `sys_action` VALUES (15, '新增页初始化', '/ad/addInit', 4, '');
INSERT INTO `sys_action` VALUES (16, '新增', '/ad/add', 4, '');
INSERT INTO `sys_action` VALUES (17, '修改页初始化', '/ad/modifyInit', 4, '');
INSERT INTO `sys_action` VALUES (18, '修改', '/ad/modify', 4, '');
INSERT INTO `sys_action` VALUES (19, '浏览', '/businesses', 5, 'GET');
INSERT INTO `sys_action` VALUES (20, '删除', '/businesses/.{1,}', 5, 'DELETE');
INSERT INTO `sys_action` VALUES (21, '新增页初始化', '/businesses/addPage', 5, 'GET');
INSERT INTO `sys_action` VALUES (22, '新增', '/businesses', 5, 'POST');
INSERT INTO `sys_action` VALUES (23, '修改页初始化', '/businesses/.{1,}', 5, 'GET');
INSERT INTO `sys_action` VALUES (24, '修改', '/businesses/.{1,}', 5, 'PUT');
INSERT INTO `sys_action` VALUES (25, '浏览', '/orderReport', 9, '');
INSERT INTO `sys_action` VALUES (26, '统计', '/orderReport/count', 9, 'GET');

-- ----------------------------
-- Table structure for sys_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO `sys_group` VALUES (1, '系统管理员');
INSERT INTO `sys_group` VALUES (2, '管理');
INSERT INTO `sys_group` VALUES (3, '业务');

-- ----------------------------
-- Table structure for sys_group_action
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_action`;
CREATE TABLE `sys_group_action`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NULL DEFAULT NULL,
  `action_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_group_action
-- ----------------------------
INSERT INTO `sys_group_action` VALUES (1, 1, 1);
INSERT INTO `sys_group_action` VALUES (2, 1, 2);
INSERT INTO `sys_group_action` VALUES (3, 1, 3);
INSERT INTO `sys_group_action` VALUES (4, 1, 4);
INSERT INTO `sys_group_action` VALUES (5, 1, 5);
INSERT INTO `sys_group_action` VALUES (6, 1, 6);
INSERT INTO `sys_group_action` VALUES (7, 1, 7);
INSERT INTO `sys_group_action` VALUES (8, 1, 8);
INSERT INTO `sys_group_action` VALUES (9, 1, 9);
INSERT INTO `sys_group_action` VALUES (10, 1, 10);
INSERT INTO `sys_group_action` VALUES (11, 1, 11);
INSERT INTO `sys_group_action` VALUES (12, 1, 12);
INSERT INTO `sys_group_action` VALUES (13, 1, 13);
INSERT INTO `sys_group_action` VALUES (14, 1, 14);
INSERT INTO `sys_group_action` VALUES (15, 1, 15);
INSERT INTO `sys_group_action` VALUES (16, 1, 16);
INSERT INTO `sys_group_action` VALUES (17, 1, 17);
INSERT INTO `sys_group_action` VALUES (18, 1, 18);
INSERT INTO `sys_group_action` VALUES (19, 1, 19);
INSERT INTO `sys_group_action` VALUES (20, 1, 20);
INSERT INTO `sys_group_action` VALUES (21, 1, 21);
INSERT INTO `sys_group_action` VALUES (22, 1, 22);
INSERT INTO `sys_group_action` VALUES (23, 1, 23);
INSERT INTO `sys_group_action` VALUES (24, 1, 24);
INSERT INTO `sys_group_action` VALUES (25, 1, 25);
INSERT INTO `sys_group_action` VALUES (26, 1, 26);

-- ----------------------------
-- Table structure for sys_group_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_menu`;
CREATE TABLE `sys_group_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_group_menu
-- ----------------------------
INSERT INTO `sys_group_menu` VALUES (1, 1, 1);
INSERT INTO `sys_group_menu` VALUES (2, 1, 2);
INSERT INTO `sys_group_menu` VALUES (3, 1, 3);
INSERT INTO `sys_group_menu` VALUES (4, 1, 4);
INSERT INTO `sys_group_menu` VALUES (5, 1, 5);
INSERT INTO `sys_group_menu` VALUES (6, 1, 6);
INSERT INTO `sys_group_menu` VALUES (7, 1, 7);
INSERT INTO `sys_group_menu` VALUES (8, 1, 8);
INSERT INTO `sys_group_menu` VALUES (9, 1, 9);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `order_num` decimal(5, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', '', 0, 1);
INSERT INTO `sys_menu` VALUES (2, '权限管理', '/auth', 1, 1);
INSERT INTO `sys_menu` VALUES (3, '内容管理', '', 0, 2);
INSERT INTO `sys_menu` VALUES (4, '广告管理', '/ad', 3, 1);
INSERT INTO `sys_menu` VALUES (5, '商户管理', '/businesses', 3, 2);
INSERT INTO `sys_menu` VALUES (6, '评论查询', '/comments', 3, 3);
INSERT INTO `sys_menu` VALUES (7, '订单查询', '/orders', 3, 4);
INSERT INTO `sys_menu` VALUES (8, '统计报表', '', 0, 3);
INSERT INTO `sys_menu` VALUES (9, '订单统计', '/orderReport', 8, 1);

-- ----------------------------
-- Table structure for sys_param
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param`  (
  `param_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param_value` datetime(0) NULL DEFAULT NULL,
  `param_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  UNIQUE INDEX `Unique_key`(`param_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_param
-- ----------------------------
INSERT INTO `sys_param` VALUES ('last_sync_star_time', NULL, '最后一次同步星星数时间');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `ch_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `Unique_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '超级管理员', 1);
INSERT INTO `sys_user` VALUES (2, 'zhangsan', '01d7f40760960e7bd9443513f22ab9af', '张三', NULL);
INSERT INTO `sys_user` VALUES (3, 'lisi', 'dc3a8f1670d65bea69b7b65048a0ac40', '李四', NULL);

SET FOREIGN_KEY_CHECKS = 1;
