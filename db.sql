/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : bdqnsxt_oa

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2018-05-28 15:40:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `_activities`
-- ----------------------------
DROP TABLE IF EXISTS `_activities`;
CREATE TABLE `_activities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `atype` varchar(255) DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUserId` bigint(20) DEFAULT '0',
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `activityText` text,
  `objectClass` varchar(255) DEFAULT NULL,
  `objectId` bigint(20) DEFAULT NULL,
  `device` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _activities
-- ----------------------------
INSERT INTO `_activities` VALUES ('1', 'ObjectCreate', '0', '系统自动--日志', '2018-05-03 15:01:45', '0', '系统自动--日志', '2018-05-03 15:01:45', 'wq（admin） 创建班级河北校区01期', 'com.bdqnsxt.oa.model.Clazz', '2', 'PC');
INSERT INTO `_activities` VALUES ('2', 'ObjectDelete', '0', '系统自动--日志', '2018-05-03 15:02:14', '0', '系统自动--日志', '2018-05-03 15:02:14', 'wq（admin） 删除班级河北校区01期', 'com.bdqnsxt.oa.model.Clazz', '2', 'PC');
INSERT INTO `_activities` VALUES ('3', 'ObjectCreate', '0', '系统自动--日志', '2018-05-03 17:07:17', '0', '系统自动--日志', '2018-05-03 17:07:17', 'wq（admin） 创建班级河北校区01期', 'com.bdqnsxt.oa.model.Clazz', '3', 'PC');
INSERT INTO `_activities` VALUES ('4', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-03 17:11:25', '0', '系统自动--日志', '2018-05-03 17:11:25', 'wq（admin） 修改班级河北校区01期~', 'com.bdqnsxt.oa.model.Clazz', '0', 'PC');
INSERT INTO `_activities` VALUES ('5', 'ObjectCreate', '0', '系统自动--日志', '2018-05-03 17:13:55', '0', '系统自动--日志', '2018-05-03 17:13:55', 'wq（admin） 创建班级济南校区02期', 'com.bdqnsxt.oa.model.Clazz', '4', 'PC');
INSERT INTO `_activities` VALUES ('6', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-03 17:14:26', '0', '系统自动--日志', '2018-05-03 17:14:26', 'wq（admin） 修改班级济南校区02期~', 'com.bdqnsxt.oa.model.Clazz', '4', 'PC');
INSERT INTO `_activities` VALUES ('7', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-03 17:14:52', '0', '系统自动--日志', '2018-05-03 17:14:52', 'wq（admin） 修改班级河北校区02期~', 'com.bdqnsxt.oa.model.Clazz', '4', 'PC');
INSERT INTO `_activities` VALUES ('8', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 10:26:58', '0', '系统自动--日志', '2018-05-04 10:26:58', 'wq（admin） 创建班级济南校区03期', 'com.bdqnsxt.oa.model.Clazz', '5', 'PC');
INSERT INTO `_activities` VALUES ('9', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 11:28:56', '0', '系统自动--日志', '2018-05-04 11:28:56', 'wq（admin） 创建班级山东校区05期', 'com.bdqnsxt.oa.model.Clazz', '6', 'PC');
INSERT INTO `_activities` VALUES ('10', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 11:31:46', '0', '系统自动--日志', '2018-05-04 11:31:46', 'wq（admin） 创建班级山东校区06期', 'com.bdqnsxt.oa.model.Clazz', '7', 'PC');
INSERT INTO `_activities` VALUES ('11', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 11:33:59', '0', '系统自动--日志', '2018-05-04 11:33:59', 'wq（admin） 创建班级山东校区08期', 'com.bdqnsxt.oa.model.Clazz', '8', 'PC');
INSERT INTO `_activities` VALUES ('12', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 12:30:00', '0', '系统自动--日志', '2018-05-04 12:30:00', 'wq（admin） 创建班级济南校区10期', 'com.bdqnsxt.oa.model.Clazz', '9', 'PC');
INSERT INTO `_activities` VALUES ('13', 'ObjectDelete', '0', '系统自动--日志', '2018-05-04 12:31:18', '0', '系统自动--日志', '2018-05-04 12:31:18', 'wq（admin） 删除班级河北校区02期~', 'com.bdqnsxt.oa.model.Clazz', '4', 'PC');
INSERT INTO `_activities` VALUES ('14', 'ObjectCreate', '0', '系统自动--日志', '2018-05-04 17:26:17', '0', '系统自动--日志', '2018-05-04 17:26:17', 'wq（admin） 创建学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('15', 'ObjectDelete', '0', '系统自动--日志', '2018-05-04 17:27:36', '0', '系统自动--日志', '2018-05-04 17:27:36', 'wq（admin） 删除学生小明', 'com.bdqnsxt.oa.model.Student', '1', 'PC');
INSERT INTO `_activities` VALUES ('16', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-04 17:29:08', '0', '系统自动--日志', '2018-05-04 17:29:08', 'wq（admin） 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('17', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 12:12:43', '0', '系统自动--日志', '2018-05-07 12:12:43', 'wq（admin） 修改班级山东校区05期', 'com.bdqnsxt.oa.model.Clazz', '6', 'PC');
INSERT INTO `_activities` VALUES ('18', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 12:12:54', '0', '系统自动--日志', '2018-05-07 12:12:54', 'wq（admin） 修改班级山东校区05期', 'com.bdqnsxt.oa.model.Clazz', '6', 'PC');
INSERT INTO `_activities` VALUES ('19', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 12:19:35', '0', '系统自动--日志', '2018-05-07 12:19:35', 'wq（admin） 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('20', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 12:23:37', '0', '系统自动--日志', '2018-05-07 12:23:37', 'wq（admin） 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('21', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 13:10:57', '0', '系统自动--日志', '2018-05-07 13:10:57', 'wq（admin） 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('22', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-07 13:11:28', '0', '系统自动--日志', '2018-05-07 13:11:28', 'wq（admin） 修改班级济南校区01期', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('23', 'ObjectCreate', '0', '系统自动--日志', '2018-05-08 17:28:23', '0', '系统自动--日志', '2018-05-08 17:28:23', 'wq（admin） 创建部门咨询部', 'com.bdqnsxt.oa.model.Department', '8', 'PC');
INSERT INTO `_activities` VALUES ('24', 'ObjectCreate', '0', '系统自动--日志', '2018-05-08 17:31:28', '0', '系统自动--日志', '2018-05-08 17:31:28', 'wq（admin） 创建部门就业部', 'com.bdqnsxt.oa.model.Department', '9', 'PC');
INSERT INTO `_activities` VALUES ('25', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:12:37', '0', '系统自动--日志', '2018-05-09 09:12:37', 'wq（admin） 创建部门教务部', 'com.bdqnsxt.oa.model.Department', '10', 'PC');
INSERT INTO `_activities` VALUES ('26', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:15:54', '0', '系统自动--日志', '2018-05-09 09:15:54', 'wq（admin） 创建部门dasfsaf', 'com.bdqnsxt.oa.model.Department', '11', 'PC');
INSERT INTO `_activities` VALUES ('27', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:22:13', '0', '系统自动--日志', '2018-05-09 09:22:13', 'wq（admin） 创建部门aaa', 'com.bdqnsxt.oa.model.Department', '12', 'PC');
INSERT INTO `_activities` VALUES ('28', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:42:27', '0', '系统自动--日志', '2018-05-09 09:42:27', 'wq（admin） 创建部门test', 'com.bdqnsxt.oa.model.Department', '13', 'PC');
INSERT INTO `_activities` VALUES ('29', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:43:23', '0', '系统自动--日志', '2018-05-09 09:43:23', 'wq（admin） 创建部门tet', 'com.bdqnsxt.oa.model.Department', '14', 'PC');
INSERT INTO `_activities` VALUES ('30', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 09:43:58', '0', '系统自动--日志', '2018-05-09 09:43:58', 'wq（admin） 创建部门test', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('31', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 09:44:43', '0', '系统自动--日志', '2018-05-09 09:44:43', 'wq（admin） 修改部门test', 'com.bdqnsxt.oa.model.Department', '0', 'PC');
INSERT INTO `_activities` VALUES ('32', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 09:45:18', '0', '系统自动--日志', '2018-05-09 09:45:18', 'wq（admin） 修改部门test1', 'com.bdqnsxt.oa.model.Department', '0', 'PC');
INSERT INTO `_activities` VALUES ('33', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 09:45:50', '0', '系统自动--日志', '2018-05-09 09:45:50', 'wq（admin） 修改部门test', 'com.bdqnsxt.oa.model.Department', '0', 'PC');
INSERT INTO `_activities` VALUES ('34', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 09:47:23', '0', '系统自动--日志', '2018-05-09 09:47:23', 'wq（admin） 修改部门test', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('35', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 10:00:52', '0', '系统自动--日志', '2018-05-09 10:00:52', 'wq（admin） 删除部门dasfsaf', 'com.bdqnsxt.oa.model.Department', '11', 'PC');
INSERT INTO `_activities` VALUES ('36', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 10:49:13', '0', '系统自动--日志', '2018-05-09 10:49:13', 'wq（admin） 创建校区sadfsdf', 'com.bdqnsxt.oa.model.School', '3', 'PC');
INSERT INTO `_activities` VALUES ('37', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 10:49:23', '0', '系统自动--日志', '2018-05-09 10:49:23', 'wq（admin） 修改校区sadfsdfaaaaa', 'com.bdqnsxt.oa.model.School', '0', 'PC');
INSERT INTO `_activities` VALUES ('38', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 10:53:27', '0', '系统自动--日志', '2018-05-09 10:53:27', 'wq（admin） 创建班级测试班级001', 'com.bdqnsxt.oa.model.Clazz', '10', 'PC');
INSERT INTO `_activities` VALUES ('39', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 10:53:41', '0', '系统自动--日志', '2018-05-09 10:53:41', 'wq（admin） 修改班级测试班级001', 'com.bdqnsxt.oa.model.Clazz', '10', 'PC');
INSERT INTO `_activities` VALUES ('40', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 10:53:58', '0', '系统自动--日志', '2018-05-09 10:53:58', 'wq（admin） 修改班级测试班级001', 'com.bdqnsxt.oa.model.Clazz', '10', 'PC');
INSERT INTO `_activities` VALUES ('41', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 10:55:34', '0', '系统自动--日志', '2018-05-09 10:55:34', 'wq（admin） 修改校区sadfsdf', 'com.bdqnsxt.oa.model.School', '3', 'PC');
INSERT INTO `_activities` VALUES ('42', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 10:56:01', '0', '系统自动--日志', '2018-05-09 10:56:01', 'wq（admin） 删除校区sadfsdf', 'com.bdqnsxt.oa.model.School', '3', 'PC');
INSERT INTO `_activities` VALUES ('43', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 11:13:33', '0', '系统自动--日志', '2018-05-09 11:13:33', 'wq（admin） 创建班级asdfsadf', 'com.bdqnsxt.oa.model.Clazz', '11', 'PC');
INSERT INTO `_activities` VALUES ('44', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 12:29:46', '0', '系统自动--日志', '2018-05-09 12:29:46', 'wq（admin） 创建用户liuliu', 'com.bdqnsxt.oa.model.User', '7', 'PC');
INSERT INTO `_activities` VALUES ('45', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 13:22:50', '0', '系统自动--日志', '2018-05-09 13:22:50', 'wq（admin） 创建用户test003', 'com.bdqnsxt.oa.model.User', '8', 'PC');
INSERT INTO `_activities` VALUES ('46', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:38:18', '0', '系统自动--日志', '2018-05-09 13:38:18', 'wq（admin） 修改用户jm123321', 'com.bdqnsxt.oa.model.User', '2', 'PC');
INSERT INTO `_activities` VALUES ('47', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 13:38:27', '0', '系统自动--日志', '2018-05-09 13:38:27', 'wq（admin） 删除用户liuliu', 'com.bdqnsxt.oa.model.User', '7', 'PC');
INSERT INTO `_activities` VALUES ('48', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:39:47', '0', '系统自动--日志', '2018-05-09 13:39:47', 'wq（admin） 修改', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('49', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:43:13', '0', '系统自动--日志', '2018-05-09 13:43:13', 'wq（admin） 修改用户wq123321', 'com.bdqnsxt.oa.model.User', '1', 'PC');
INSERT INTO `_activities` VALUES ('50', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:43:28', '0', '系统自动--日志', '2018-05-09 13:43:28', 'wq（admin） 修改用户wq123321', 'com.bdqnsxt.oa.model.User', '1', 'PC');
INSERT INTO `_activities` VALUES ('51', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 13:43:38', '0', '系统自动--日志', '2018-05-09 13:43:38', 'wq（admin） 删除用户test003', 'com.bdqnsxt.oa.model.User', '8', 'PC');
INSERT INTO `_activities` VALUES ('52', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:43:44', '0', '系统自动--日志', '2018-05-09 13:43:44', 'wq（admin） 修改', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('53', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:44:51', '0', '系统自动--日志', '2018-05-09 13:44:51', 'wq（admin） 修改', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('54', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:45:00', '0', '系统自动--日志', '2018-05-09 13:45:00', 'wq（admin） 修改', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('55', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:46:30', '0', '系统自动--日志', '2018-05-09 13:46:30', 'wq（admin） 修改', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('56', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 13:48:09', '0', '系统自动--日志', '2018-05-09 13:48:09', 'wq（admin） 删除部门', 'com.bdqnsxt.oa.model.Department', '15', 'PC');
INSERT INTO `_activities` VALUES ('57', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:48:38', '0', '系统自动--日志', '2018-05-09 13:48:38', 'wq（admin） 修改部门总部经理处', 'com.bdqnsxt.oa.model.Department', '100', 'PC');
INSERT INTO `_activities` VALUES ('58', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 13:48:55', '0', '系统自动--日志', '2018-05-09 13:48:55', 'wq（admin） 创建部门市场部', 'com.bdqnsxt.oa.model.Department', '16', 'PC');
INSERT INTO `_activities` VALUES ('59', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 13:49:31', '0', '系统自动--日志', '2018-05-09 13:49:31', 'wq（admin） 创建校区测试0001', 'com.bdqnsxt.oa.model.School', '4', 'PC');
INSERT INTO `_activities` VALUES ('60', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:49:38', '0', '系统自动--日志', '2018-05-09 13:49:38', 'wq（admin） 修改校区测试00012', 'com.bdqnsxt.oa.model.School', '4', 'PC');
INSERT INTO `_activities` VALUES ('61', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:50:05', '0', '系统自动--日志', '2018-05-09 13:50:05', 'wq（admin） 修改班级济南校区01期~~', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('62', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 13:50:15', '0', '系统自动--日志', '2018-05-09 13:50:15', 'wq（admin） 修改班级济南校区01期~~', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('63', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 13:50:28', '0', '系统自动--日志', '2018-05-09 13:50:28', 'wq（admin） 删除班级asdfsadf', 'com.bdqnsxt.oa.model.Clazz', '11', 'PC');
INSERT INTO `_activities` VALUES ('64', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 14:00:46', '0', '系统自动--日志', '2018-05-09 14:00:46', 'wq（admin） 修改班级河北校区01期~~', 'com.bdqnsxt.oa.model.Clazz', '3', 'PC');
INSERT INTO `_activities` VALUES ('65', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-09 14:01:13', '0', '系统自动--日志', '2018-05-09 14:01:13', 'wq（admin） 修改班级济南校区01期', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('66', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 14:20:12', '0', '系统自动--日志', '2018-05-09 14:20:12', 'wq（admin） 创建学生asdffsd', 'com.bdqnsxt.oa.model.Student', '6', 'PC');
INSERT INTO `_activities` VALUES ('67', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 14:26:37', '0', '系统自动--日志', '2018-05-09 14:26:37', 'wq（admin） 删除班级测试班级001', 'com.bdqnsxt.oa.model.Clazz', '10', 'PC');
INSERT INTO `_activities` VALUES ('68', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 14:27:43', '0', '系统自动--日志', '2018-05-09 14:27:43', 'wq（admin） 删除班级济南校区10期', 'com.bdqnsxt.oa.model.Clazz', '9', 'PC');
INSERT INTO `_activities` VALUES ('69', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 14:37:01', '0', '系统自动--日志', '2018-05-09 14:37:01', 'wq（admin） 删除班级山东校区08期', 'com.bdqnsxt.oa.model.Clazz', '8', 'PC');
INSERT INTO `_activities` VALUES ('70', 'ObjectCreate', '0', '系统自动--日志', '2018-05-09 14:43:03', '0', '系统自动--日志', '2018-05-09 14:43:03', 'wq（admin） 创建部门aaa', 'com.bdqnsxt.oa.model.Department', '1000', 'PC');
INSERT INTO `_activities` VALUES ('71', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 14:43:56', '0', '系统自动--日志', '2018-05-09 14:43:56', 'wq（admin） 删除部门aaa', 'com.bdqnsxt.oa.model.Department', '1000', 'PC');
INSERT INTO `_activities` VALUES ('72', 'ObjectDelete', '0', '系统自动--日志', '2018-05-09 14:48:21', '0', '系统自动--日志', '2018-05-09 14:48:21', 'wq（admin） 删除班级山东校区06期', 'com.bdqnsxt.oa.model.Clazz', '7', 'PC');
INSERT INTO `_activities` VALUES ('73', 'ObjectCreate', '0', '系统自动--日志', '2018-05-10 15:22:17', '0', '系统自动--日志', '2018-05-10 15:22:17', '日志数据错误', 'com.bdqnsxt.oa.model.User', '9', 'PC');
INSERT INTO `_activities` VALUES ('74', 'ObjectCreate', '0', '系统自动--日志', '2018-05-10 15:30:31', '0', '系统自动--日志', '2018-05-10 15:30:31', '日志数据错误', 'com.bdqnsxt.oa.model.User', '10', 'PC');
INSERT INTO `_activities` VALUES ('75', 'ObjectCreate', '0', '系统自动--日志', '2018-05-10 15:40:33', '0', '系统自动--日志', '2018-05-10 15:40:35', '日志数据错误', 'com.bdqnsxt.oa.model.User', '11', 'PC');
INSERT INTO `_activities` VALUES ('76', 'ObjectDelete', '0', '系统自动--日志', '2018-05-10 15:51:40', '0', '系统自动--日志', '2018-05-10 15:51:40', 'wq2018 删除部门教务部', 'com.bdqnsxt.oa.model.Department', '10', 'PC');
INSERT INTO `_activities` VALUES ('77', 'ObjectCreate', '0', '系统自动--日志', '2018-05-10 15:53:46', '0', '系统自动--日志', '2018-05-10 15:53:46', 'wq2018 创建部门测试部门', 'com.bdqnsxt.oa.model.Department', '1001', 'PC');
INSERT INTO `_activities` VALUES ('78', 'ObjectCreate', '0', '系统自动--日志', '2018-05-11 11:34:35', '0', '系统自动--日志', '2018-05-11 11:34:35', 'wq2018 创建用户wqwqwqr3r', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('79', 'ObjectCreate', '0', '系统自动--日志', '2018-05-11 11:40:00', '0', '系统自动--日志', '2018-05-11 11:40:00', 'wq2018 创建用户szcvsdf', 'com.bdqnsxt.oa.model.User', '13', 'PC');
INSERT INTO `_activities` VALUES ('80', 'ObjectCreate', '0', '系统自动--日志', '2018-05-11 11:57:34', '0', '系统自动--日志', '2018-05-11 11:57:34', 'wq2018 创建用户dbfibibg', 'com.bdqnsxt.oa.model.User', '14', 'PC');
INSERT INTO `_activities` VALUES ('81', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-11 12:05:41', '0', '系统自动--日志', '2018-05-11 12:05:41', 'wq2018 修改用户wqwqwqr3r', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('82', 'ObjectCreate', '0', '系统自动--日志', '2018-05-11 12:11:18', '0', '系统自动--日志', '2018-05-11 12:11:18', 'wq2018 创建用户test876', 'com.bdqnsxt.oa.model.User', '16', 'PC');
INSERT INTO `_activities` VALUES ('83', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-11 14:05:35', '0', '系统自动--日志', '2018-05-11 14:05:35', 'wq2018 修改用户dbfibibg', 'com.bdqnsxt.oa.model.User', '14', 'PC');
INSERT INTO `_activities` VALUES ('84', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-11 14:06:44', '0', '系统自动--日志', '2018-05-11 14:06:44', 'wq2018 修改用户dbfibibg', 'com.bdqnsxt.oa.model.User', '14', 'PC');
INSERT INTO `_activities` VALUES ('85', 'ObjectCreate', '0', '系统自动--日志', '2018-05-11 15:43:44', '0', '系统自动--日志', '2018-05-11 15:43:44', 'wq2018 创建用户admin009', 'com.bdqnsxt.oa.model.User', '18', 'PC');
INSERT INTO `_activities` VALUES ('86', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-11 15:44:55', '0', '系统自动--日志', '2018-05-11 15:44:55', 'wq2018 修改用户admin009', 'com.bdqnsxt.oa.model.User', '18', 'PC');
INSERT INTO `_activities` VALUES ('87', 'ObjectCreate', '0', '系统自动--日志', '2018-05-12 17:31:47', '0', '系统自动--日志', '2018-05-12 17:31:47', 'admin009 创建角色咨询师', 'com.bdqnsxt.oa.model.SystemRole', '4', 'PC');
INSERT INTO `_activities` VALUES ('88', 'ObjectCreate', '0', '系统自动--日志', '2018-05-12 17:34:10', '0', '系统自动--日志', '2018-05-12 17:34:10', 'admin009 创建角色就业老师', 'com.bdqnsxt.oa.model.SystemRole', '5', 'PC');
INSERT INTO `_activities` VALUES ('89', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:00:52', '0', '系统自动--日志', '2018-05-14 09:00:52', 'admin009 创建角色咨询主管', 'com.bdqnsxt.oa.model.SystemRole', '6', 'PC');
INSERT INTO `_activities` VALUES ('90', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:02:41', '0', '系统自动--日志', '2018-05-14 09:02:41', 'admin009 创建角色教学总监', 'com.bdqnsxt.oa.model.SystemRole', '7', 'PC');
INSERT INTO `_activities` VALUES ('91', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:03:43', '0', '系统自动--日志', '2018-05-14 09:03:43', 'admin009 创建角色就业主管', 'com.bdqnsxt.oa.model.SystemRole', '8', 'PC');
INSERT INTO `_activities` VALUES ('92', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:15:39', '0', '系统自动--日志', '2018-05-14 09:15:39', 'admin009 创建角色测试岗位', 'com.bdqnsxt.oa.model.SystemRole', '9', 'PC');
INSERT INTO `_activities` VALUES ('93', 'ObjectDelete', '0', '系统自动--日志', '2018-05-14 09:28:30', '0', '系统自动--日志', '2018-05-14 09:28:30', 'admin009 删除角色测试岗位', 'com.bdqnsxt.oa.model.SystemRole', '9', 'PC');
INSERT INTO `_activities` VALUES ('94', 'ObjectDelete', '0', '系统自动--日志', '2018-05-14 09:29:58', '0', '系统自动--日志', '2018-05-14 09:29:58', 'admin009 删除角色就业主管', 'com.bdqnsxt.oa.model.SystemRole', '8', 'PC');
INSERT INTO `_activities` VALUES ('95', 'ObjectDelete', '0', '系统自动--日志', '2018-05-14 09:53:32', '0', '系统自动--日志', '2018-05-14 09:53:32', 'admin009 删除角色咨询师', 'com.bdqnsxt.oa.model.SystemRole', '4', 'PC');
INSERT INTO `_activities` VALUES ('96', 'ObjectDelete', '0', '系统自动--日志', '2018-05-14 09:53:42', '0', '系统自动--日志', '2018-05-14 09:53:42', 'admin009 删除角色咨询主管', 'com.bdqnsxt.oa.model.SystemRole', '6', 'PC');
INSERT INTO `_activities` VALUES ('97', 'ObjectDelete', '0', '系统自动--日志', '2018-05-14 09:54:19', '0', '系统自动--日志', '2018-05-14 09:54:19', 'admin009 删除角色管理人员', 'com.bdqnsxt.oa.model.SystemRole', '1', 'PC');
INSERT INTO `_activities` VALUES ('98', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:55:52', '0', '系统自动--日志', '2018-05-14 09:55:52', 'admin009 创建角色咨询主管', 'com.bdqnsxt.oa.model.SystemRole', '10', 'PC');
INSERT INTO `_activities` VALUES ('99', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 09:56:00', '0', '系统自动--日志', '2018-05-14 09:56:00', 'admin009 创建角色咨询师', 'com.bdqnsxt.oa.model.SystemRole', '11', 'PC');
INSERT INTO `_activities` VALUES ('100', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-14 09:56:09', '0', '系统自动--日志', '2018-05-14 09:56:09', 'admin009 修改角色咨询师', 'com.bdqnsxt.oa.model.SystemRole', '11', 'PC');
INSERT INTO `_activities` VALUES ('101', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 14:09:40', '0', '系统自动--日志', '2018-05-14 14:09:40', 'admin009 创建菜单权限roleId为2', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('102', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-14 14:50:19', '0', '系统自动--日志', '2018-05-14 14:50:19', 'admin009 修改菜单权限roleId为10', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('103', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 15:36:20', '0', '系统自动--日志', '2018-05-14 15:36:20', 'admin009 创建部门教学部', 'com.bdqnsxt.oa.model.Department', '1004', 'PC');
INSERT INTO `_activities` VALUES ('104', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 15:36:35', '0', '系统自动--日志', '2018-05-14 15:36:35', 'admin009 创建角色讲师', 'com.bdqnsxt.oa.model.SystemRole', '12', 'PC');
INSERT INTO `_activities` VALUES ('105', 'ObjectCreate', '0', '系统自动--日志', '2018-05-14 16:51:20', '0', '系统自动--日志', '2018-05-14 16:51:20', 'admin009 创建角色讲师', 'com.bdqnsxt.oa.model.SystemRole', '2010', 'PC');
INSERT INTO `_activities` VALUES ('106', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-14 17:11:07', '0', '系统自动--日志', '2018-05-14 17:11:07', 'admin009 修改菜单权限roleId为2002', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('107', 'ObjectCopy', '0', '系统自动--日志', '2018-05-15 09:15:26', '0', '系统自动--日志', '2018-05-15 09:15:26', 'admin009 复制菜单权限岗位id为2010;被复制的岗位id为2002', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('108', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 09:49:15', '0', '系统自动--日志', '2018-05-15 09:49:15', 'admin009 创建部门行政部', 'com.bdqnsxt.oa.model.Department', '1005', 'PC');
INSERT INTO `_activities` VALUES ('109', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 09:49:29', '0', '系统自动--日志', '2018-05-15 09:49:29', 'admin009 创建角色财务', 'com.bdqnsxt.oa.model.SystemRole', '2011', 'PC');
INSERT INTO `_activities` VALUES ('110', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 09:49:40', '0', '系统自动--日志', '2018-05-15 09:49:40', 'admin009 创建角色班主任', 'com.bdqnsxt.oa.model.SystemRole', '2012', 'PC');
INSERT INTO `_activities` VALUES ('111', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 09:49:51', '0', '系统自动--日志', '2018-05-15 09:49:51', 'admin009 修改菜单权限岗位id为2012', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('112', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 10:02:42', '0', '系统自动--日志', '2018-05-15 10:02:42', 'admin009 创建用户test006', 'com.bdqnsxt.oa.model.User', '19', 'PC');
INSERT INTO `_activities` VALUES ('113', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 10:02:59', '0', '系统自动--日志', '2018-05-15 10:02:59', 'admin009 修改用户test006', 'com.bdqnsxt.oa.model.User', '19', 'PC');
INSERT INTO `_activities` VALUES ('114', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 10:17:10', '0', '系统自动--日志', '2018-05-15 10:17:10', 'admin009 修改班级济南校区01期', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('115', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 10:18:16', '0', '系统自动--日志', '2018-05-15 10:18:16', 'admin009 创建班级济南校区06期', 'com.bdqnsxt.oa.model.Clazz', '7', 'PC');
INSERT INTO `_activities` VALUES ('116', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:23:11', '0', '系统自动--日志', '2018-05-15 11:23:11', 'admin009 创建角色竞价专员', 'com.bdqnsxt.oa.model.SystemRole', '2013', 'PC');
INSERT INTO `_activities` VALUES ('117', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:23:41', '0', '系统自动--日志', '2018-05-15 11:23:41', 'admin009 删除角色竞价专员', 'com.bdqnsxt.oa.model.SystemRole', '2013', 'PC');
INSERT INTO `_activities` VALUES ('118', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:24:09', '0', '系统自动--日志', '2018-05-15 11:24:09', 'admin009 创建部门中心管理', 'com.bdqnsxt.oa.model.Department', '1006', 'PC');
INSERT INTO `_activities` VALUES ('119', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:24:29', '0', '系统自动--日志', '2018-05-15 11:24:29', 'admin009 创建角色中心校长', 'com.bdqnsxt.oa.model.SystemRole', '2014', 'PC');
INSERT INTO `_activities` VALUES ('120', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:25:05', '0', '系统自动--日志', '2018-05-15 11:25:05', 'admin009 创建角色竞价专员', 'com.bdqnsxt.oa.model.SystemRole', '2015', 'PC');
INSERT INTO `_activities` VALUES ('121', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:25:16', '0', '系统自动--日志', '2018-05-15 11:25:16', 'admin009 创建角色在线咨询师', 'com.bdqnsxt.oa.model.SystemRole', '2016', 'PC');
INSERT INTO `_activities` VALUES ('122', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:25:40', '0', '系统自动--日志', '2018-05-15 11:25:40', 'admin009 创建角色咨询主管', 'com.bdqnsxt.oa.model.SystemRole', '2017', 'PC');
INSERT INTO `_activities` VALUES ('123', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:25:48', '0', '系统自动--日志', '2018-05-15 11:25:48', 'admin009 创建角色咨询师', 'com.bdqnsxt.oa.model.SystemRole', '2018', 'PC');
INSERT INTO `_activities` VALUES ('124', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:26:06', '0', '系统自动--日志', '2018-05-15 11:26:06', 'admin009 创建角色咨询助理', 'com.bdqnsxt.oa.model.SystemRole', '2019', 'PC');
INSERT INTO `_activities` VALUES ('125', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:26:39', '0', '系统自动--日志', '2018-05-15 11:26:39', 'admin009 修改角色就业专员', 'com.bdqnsxt.oa.model.SystemRole', '2005', 'PC');
INSERT INTO `_activities` VALUES ('126', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:26:46', '0', '系统自动--日志', '2018-05-15 11:26:46', 'admin009 创建角色就业部经理', 'com.bdqnsxt.oa.model.SystemRole', '2020', 'PC');
INSERT INTO `_activities` VALUES ('127', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:27:14', '0', '系统自动--日志', '2018-05-15 11:27:14', 'admin009 创建角色市场活动主管', 'com.bdqnsxt.oa.model.SystemRole', '2021', 'PC');
INSERT INTO `_activities` VALUES ('128', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:27:23', '0', '系统自动--日志', '2018-05-15 11:27:23', 'admin009 创建角色市场活动专员', 'com.bdqnsxt.oa.model.SystemRole', '2022', 'PC');
INSERT INTO `_activities` VALUES ('129', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:27:47', '0', '系统自动--日志', '2018-05-15 11:27:47', 'admin009 创建角色电话销售专员', 'com.bdqnsxt.oa.model.SystemRole', '2023', 'PC');
INSERT INTO `_activities` VALUES ('130', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:29:40', '0', '系统自动--日志', '2018-05-15 11:29:40', 'admin009 修改角色教员', 'com.bdqnsxt.oa.model.SystemRole', '2002', 'PC');
INSERT INTO `_activities` VALUES ('131', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:29:43', '0', '系统自动--日志', '2018-05-15 11:29:43', 'admin009 删除角色助教', 'com.bdqnsxt.oa.model.SystemRole', '2003', 'PC');
INSERT INTO `_activities` VALUES ('132', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:36:09', '0', '系统自动--日志', '2018-05-15 11:36:09', 'admin009 修改角色讲师', 'com.bdqnsxt.oa.model.SystemRole', '2002', 'PC');
INSERT INTO `_activities` VALUES ('133', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:36:15', '0', '系统自动--日志', '2018-05-15 11:36:15', 'admin009 修改角色助教', 'com.bdqnsxt.oa.model.SystemRole', '2007', 'PC');
INSERT INTO `_activities` VALUES ('134', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:39:24', '0', '系统自动--日志', '2018-05-15 11:39:24', 'admin009 创建角色技术顾问', 'com.bdqnsxt.oa.model.SystemRole', '2024', 'PC');
INSERT INTO `_activities` VALUES ('135', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:39:32', '0', '系统自动--日志', '2018-05-15 11:39:32', 'admin009 创建角色技术支持', 'com.bdqnsxt.oa.model.SystemRole', '2025', 'PC');
INSERT INTO `_activities` VALUES ('136', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:40:00', '0', '系统自动--日志', '2018-05-15 11:40:00', 'admin009 创建角色教质部经理', 'com.bdqnsxt.oa.model.SystemRole', '2026', 'PC');
INSERT INTO `_activities` VALUES ('137', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:40:39', '0', '系统自动--日志', '2018-05-15 11:40:39', 'admin009 创建角色学术部经理', 'com.bdqnsxt.oa.model.SystemRole', '2027', 'PC');
INSERT INTO `_activities` VALUES ('138', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:41:55', '0', '系统自动--日志', '2018-05-15 11:41:55', 'admin009 修改角色会计', 'com.bdqnsxt.oa.model.SystemRole', '2011', 'PC');
INSERT INTO `_activities` VALUES ('139', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:42:06', '0', '系统自动--日志', '2018-05-15 11:42:06', 'admin009 修改角色出纳', 'com.bdqnsxt.oa.model.SystemRole', '2012', 'PC');
INSERT INTO `_activities` VALUES ('140', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:42:30', '0', '系统自动--日志', '2018-05-15 11:42:30', 'admin009 创建角色行政专员', 'com.bdqnsxt.oa.model.SystemRole', '2028', 'PC');
INSERT INTO `_activities` VALUES ('141', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:42:40', '0', '系统自动--日志', '2018-05-15 11:42:40', 'admin009 创建角色人事专员', 'com.bdqnsxt.oa.model.SystemRole', '2029', 'PC');
INSERT INTO `_activities` VALUES ('142', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:43:04', '0', '系统自动--日志', '2018-05-15 11:43:04', 'admin009 创建部门教务部', 'com.bdqnsxt.oa.model.Department', '1007', 'PC');
INSERT INTO `_activities` VALUES ('143', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:43:41', '0', '系统自动--日志', '2018-05-15 11:43:41', 'admin009 删除角色助教', 'com.bdqnsxt.oa.model.SystemRole', '2007', 'PC');
INSERT INTO `_activities` VALUES ('144', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-15 11:43:50', '0', '系统自动--日志', '2018-05-15 11:43:50', 'admin009 修改角色教员', 'com.bdqnsxt.oa.model.SystemRole', '2002', 'PC');
INSERT INTO `_activities` VALUES ('145', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:44:09', '0', '系统自动--日志', '2018-05-15 11:44:09', 'admin009 删除角色技术支持', 'com.bdqnsxt.oa.model.SystemRole', '2025', 'PC');
INSERT INTO `_activities` VALUES ('146', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:44:18', '0', '系统自动--日志', '2018-05-15 11:44:18', 'admin009 删除角色教质部经理', 'com.bdqnsxt.oa.model.SystemRole', '2026', 'PC');
INSERT INTO `_activities` VALUES ('147', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:44:31', '0', '系统自动--日志', '2018-05-15 11:44:31', 'admin009 创建角色教务', 'com.bdqnsxt.oa.model.SystemRole', '2030', 'PC');
INSERT INTO `_activities` VALUES ('148', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:44:39', '0', '系统自动--日志', '2018-05-15 11:44:39', 'admin009 创建角色辅导员', 'com.bdqnsxt.oa.model.SystemRole', '2031', 'PC');
INSERT INTO `_activities` VALUES ('149', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:45:10', '0', '系统自动--日志', '2018-05-15 11:45:10', 'admin009 创建角色班主任', 'com.bdqnsxt.oa.model.SystemRole', '2032', 'PC');
INSERT INTO `_activities` VALUES ('150', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:45:42', '0', '系统自动--日志', '2018-05-15 11:45:42', 'admin009 删除角色技术顾问', 'com.bdqnsxt.oa.model.SystemRole', '2024', 'PC');
INSERT INTO `_activities` VALUES ('151', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:45:53', '0', '系统自动--日志', '2018-05-15 11:45:53', 'admin009 创建部门技术支持', 'com.bdqnsxt.oa.model.Department', '1008', 'PC');
INSERT INTO `_activities` VALUES ('152', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:46:06', '0', '系统自动--日志', '2018-05-15 11:46:06', 'admin009 创建角色网络主管', 'com.bdqnsxt.oa.model.SystemRole', '2033', 'PC');
INSERT INTO `_activities` VALUES ('153', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:46:19', '0', '系统自动--日志', '2018-05-15 11:46:19', 'admin009 创建角色技术顾问', 'com.bdqnsxt.oa.model.SystemRole', '2034', 'PC');
INSERT INTO `_activities` VALUES ('154', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:46:28', '0', '系统自动--日志', '2018-05-15 11:46:28', 'admin009 创建角色技术支持', 'com.bdqnsxt.oa.model.SystemRole', '2035', 'PC');
INSERT INTO `_activities` VALUES ('155', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:46:55', '0', '系统自动--日志', '2018-05-15 11:46:55', 'admin009 创建角色教质部经理', 'com.bdqnsxt.oa.model.SystemRole', '2036', 'PC');
INSERT INTO `_activities` VALUES ('156', 'ObjectDelete', '0', '系统自动--日志', '2018-05-15 11:52:02', '0', '系统自动--日志', '2018-05-15 11:52:02', 'admin009 删除角色辅导员', 'com.bdqnsxt.oa.model.SystemRole', '2031', 'PC');
INSERT INTO `_activities` VALUES ('157', 'ObjectCreate', '0', '系统自动--日志', '2018-05-15 11:52:13', '0', '系统自动--日志', '2018-05-15 11:52:13', 'admin009 创建角色辅导员', 'com.bdqnsxt.oa.model.SystemRole', '2037', 'PC');
INSERT INTO `_activities` VALUES ('158', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 11:00:52', '0', '系统自动--日志', '2018-05-16 11:00:52', 'admin009 创建文档分类test', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('159', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:39:26', '0', '系统自动--日志', '2018-05-16 11:39:26', 'admin009 修改文档分类test222', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('160', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:41:14', '0', '系统自动--日志', '2018-05-16 11:41:14', 'admin009 修改文档分类test2223', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('161', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:51:22', '0', '系统自动--日志', '2018-05-16 11:51:22', 'admin009 修改用户szcvsdf', 'com.bdqnsxt.oa.model.User', '13', 'PC');
INSERT INTO `_activities` VALUES ('162', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:51:39', '0', '系统自动--日志', '2018-05-16 11:51:39', 'admin009 修改部门咨询部', 'com.bdqnsxt.oa.model.Department', '1000', 'PC');
INSERT INTO `_activities` VALUES ('163', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:52:09', '0', '系统自动--日志', '2018-05-16 11:52:09', 'admin009 修改文档分类test222344', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('164', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:52:31', '0', '系统自动--日志', '2018-05-16 11:52:31', 'admin009 修改部门咨询部', 'com.bdqnsxt.oa.model.Department', '1000', 'PC');
INSERT INTO `_activities` VALUES ('165', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:53:03', '0', '系统自动--日志', '2018-05-16 11:53:03', 'admin009 修改文档分类test222355', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('166', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:57:37', '0', '系统自动--日志', '2018-05-16 11:57:37', 'admin009 修改文档分类test222355`', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('167', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 11:59:09', '0', '系统自动--日志', '2018-05-16 11:59:09', 'admin009 修改校区山东济南总校区', 'com.bdqnsxt.oa.model.School', '1', 'PC');
INSERT INTO `_activities` VALUES ('168', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:01:54', '0', '系统自动--日志', '2018-05-16 12:01:54', 'admin009 修改文档分类test22', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('169', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:07:29', '0', '系统自动--日志', '2018-05-16 12:07:29', 'admin009 修改文档分类test2233', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('170', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:09:18', '0', '系统自动--日志', '2018-05-16 12:09:18', 'admin009 修改文档分类test2233``', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('171', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:09:21', '0', '系统自动--日志', '2018-05-16 12:09:21', 'admin009 修改文档分类test2233``11', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('172', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:10:33', '0', '系统自动--日志', '2018-05-16 12:10:33', 'admin009 修改部门咨询部', 'com.bdqnsxt.oa.model.Department', '1000', 'PC');
INSERT INTO `_activities` VALUES ('173', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:14:12', '0', '系统自动--日志', '2018-05-16 12:14:12', 'admin009 修改文档分类test', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('174', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 12:15:02', '0', '系统自动--日志', '2018-05-16 12:15:02', 'admin009 修改文档分类test123', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('175', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 12:23:13', '0', '系统自动--日志', '2018-05-16 12:23:13', 'admin009 创建部门test', 'com.bdqnsxt.oa.model.Department', '1009', 'PC');
INSERT INTO `_activities` VALUES ('176', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 12:23:18', '0', '系统自动--日志', '2018-05-16 12:23:18', 'admin009 删除部门test', 'com.bdqnsxt.oa.model.Department', '1009', 'PC');
INSERT INTO `_activities` VALUES ('177', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 12:30:19', '0', '系统自动--日志', '2018-05-16 12:30:19', 'admin009 删除文档分类test123', 'com.bdqnsxt.oa.model.DocumentCategory', '30', 'PC');
INSERT INTO `_activities` VALUES ('178', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:36:56', '0', '系统自动--日志', '2018-05-16 13:36:56', 'admin009 创建文档分类中心考核体系（参考）', 'com.bdqnsxt.oa.model.DocumentCategory', '31', 'PC');
INSERT INTO `_activities` VALUES ('179', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:50:16', '0', '系统自动--日志', '2018-05-16 13:50:16', 'admin009 创建文档分类指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '32', 'PC');
INSERT INTO `_activities` VALUES ('180', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:50:36', '0', '系统自动--日志', '2018-05-16 13:50:36', 'admin009 创建文档分类网络主管岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '33', 'PC');
INSERT INTO `_activities` VALUES ('181', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:50:50', '0', '系统自动--日志', '2018-05-16 13:50:50', 'admin009 创建文档分类01网络推广指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '34', 'PC');
INSERT INTO `_activities` VALUES ('182', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:51:13', '0', '系统自动--日志', '2018-05-16 13:51:13', 'admin009 创建文档分类竞价专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '35', 'PC');
INSERT INTO `_activities` VALUES ('183', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:51:31', '0', '系统自动--日志', '2018-05-16 13:51:31', 'admin009 创建文档分类在线咨询师岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '36', 'PC');
INSERT INTO `_activities` VALUES ('184', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:51:52', '0', '系统自动--日志', '2018-05-16 13:51:52', 'admin009 创建文档分类市场活动主管岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '37', 'PC');
INSERT INTO `_activities` VALUES ('185', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:52:16', '0', '系统自动--日志', '2018-05-16 13:52:16', 'admin009 创建文档分类02市场活动指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '38', 'PC');
INSERT INTO `_activities` VALUES ('186', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:52:45', '0', '系统自动--日志', '2018-05-16 13:52:45', 'admin009 创建文档分类市场活动专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '39', 'PC');
INSERT INTO `_activities` VALUES ('187', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 13:52:54', '0', '系统自动--日志', '2018-05-16 13:52:54', 'admin009 修改文档分类网络推广指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '34', 'PC');
INSERT INTO `_activities` VALUES ('188', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 13:53:03', '0', '系统自动--日志', '2018-05-16 13:53:03', 'admin009 修改文档分类市场活动指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '38', 'PC');
INSERT INTO `_activities` VALUES ('189', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:53:24', '0', '系统自动--日志', '2018-05-16 13:53:24', 'admin009 创建文档分类电话销售专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '40', 'PC');
INSERT INTO `_activities` VALUES ('190', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:53:43', '0', '系统自动--日志', '2018-05-16 13:53:43', 'admin009 创建文档分类咨询主管岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '41', 'PC');
INSERT INTO `_activities` VALUES ('191', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:53:59', '0', '系统自动--日志', '2018-05-16 13:53:59', 'admin009 创建文档分类咨询业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '42', 'PC');
INSERT INTO `_activities` VALUES ('192', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:54:14', '0', '系统自动--日志', '2018-05-16 13:54:14', 'admin009 创建文档分类咨询师岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '43', 'PC');
INSERT INTO `_activities` VALUES ('193', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:54:50', '0', '系统自动--日志', '2018-05-16 13:54:50', 'admin009 创建文档分类咨询助理岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '44', 'PC');
INSERT INTO `_activities` VALUES ('194', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:55:06', '0', '系统自动--日志', '2018-05-16 13:55:06', 'admin009 创建文档分类学术部经理岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '45', 'PC');
INSERT INTO `_activities` VALUES ('195', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:55:23', '0', '系统自动--日志', '2018-05-16 13:55:23', 'admin009 创建文档分类学士后教学业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '46', 'PC');
INSERT INTO `_activities` VALUES ('196', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:55:40', '0', '系统自动--日志', '2018-05-16 13:55:40', 'admin009 创建文档分类教学业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '47', 'PC');
INSERT INTO `_activities` VALUES ('197', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:55:56', '0', '系统自动--日志', '2018-05-16 13:55:56', 'admin009 创建文档分类教员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '48', 'PC');
INSERT INTO `_activities` VALUES ('198', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:56:11', '0', '系统自动--日志', '2018-05-16 13:56:11', 'admin009 创建文档分类技术顾问岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '49', 'PC');
INSERT INTO `_activities` VALUES ('199', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:56:27', '0', '系统自动--日志', '2018-05-16 13:56:27', 'admin009 创建文档分类技术支持岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '50', 'PC');
INSERT INTO `_activities` VALUES ('200', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:56:44', '0', '系统自动--日志', '2018-05-16 13:56:44', 'admin009 创建文档分类教质部经理岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '51', 'PC');
INSERT INTO `_activities` VALUES ('201', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:56:59', '0', '系统自动--日志', '2018-05-16 13:56:59', 'admin009 创建文档分类08学士后教质业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '52', 'PC');
INSERT INTO `_activities` VALUES ('202', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 13:57:05', '0', '系统自动--日志', '2018-05-16 13:57:05', 'admin009 修改文档分类学士后教质业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '52', 'PC');
INSERT INTO `_activities` VALUES ('203', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:57:20', '0', '系统自动--日志', '2018-05-16 13:57:20', 'admin009 创建文档分类教质业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '53', 'PC');
INSERT INTO `_activities` VALUES ('204', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:57:37', '0', '系统自动--日志', '2018-05-16 13:57:37', 'admin009 创建文档分类班主任岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '54', 'PC');
INSERT INTO `_activities` VALUES ('205', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:57:50', '0', '系统自动--日志', '2018-05-16 13:57:50', 'admin009 创建文档分类辅导员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '55', 'PC');
INSERT INTO `_activities` VALUES ('206', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:58:05', '0', '系统自动--日志', '2018-05-16 13:58:05', 'admin009 创建文档分类教务岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '56', 'PC');
INSERT INTO `_activities` VALUES ('207', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:58:24', '0', '系统自动--日志', '2018-05-16 13:58:24', 'admin009 创建文档分类就业部经理岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '57', 'PC');
INSERT INTO `_activities` VALUES ('208', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:58:39', '0', '系统自动--日志', '2018-05-16 13:58:39', 'admin009 创建文档分类就业业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '58', 'PC');
INSERT INTO `_activities` VALUES ('209', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:58:54', '0', '系统自动--日志', '2018-05-16 13:58:54', 'admin009 创建文档分类就业专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '59', 'PC');
INSERT INTO `_activities` VALUES ('210', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:59:13', '0', '系统自动--日志', '2018-05-16 13:59:13', 'admin009 创建文档分类人事专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '60', 'PC');
INSERT INTO `_activities` VALUES ('211', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 13:59:54', '0', '系统自动--日志', '2018-05-16 13:59:54', 'admin009 创建文档分类行政专员岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '61', 'PC');
INSERT INTO `_activities` VALUES ('212', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:00:08', '0', '系统自动--日志', '2018-05-16 14:00:08', 'admin009 创建文档分类出纳岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '62', 'PC');
INSERT INTO `_activities` VALUES ('213', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:00:22', '0', '系统自动--日志', '2018-05-16 14:00:22', 'admin009 创建文档分类会计岗位附件', 'com.bdqnsxt.oa.model.DocumentCategory', '63', 'PC');
INSERT INTO `_activities` VALUES ('214', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:01:14', '0', '系统自动--日志', '2018-05-16 14:01:14', 'admin009 创建文档分类01网络推广指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '64', 'PC');
INSERT INTO `_activities` VALUES ('215', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:01:26', '0', '系统自动--日志', '2018-05-16 14:01:26', 'admin009 创建文档分类02市场活动指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '65', 'PC');
INSERT INTO `_activities` VALUES ('216', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:01:40', '0', '系统自动--日志', '2018-05-16 14:01:40', 'admin009 创建文档分类03咨询业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '66', 'PC');
INSERT INTO `_activities` VALUES ('217', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:01:51', '0', '系统自动--日志', '2018-05-16 14:01:51', 'admin009 创建文档分类04教学业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '67', 'PC');
INSERT INTO `_activities` VALUES ('218', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:02:02', '0', '系统自动--日志', '2018-05-16 14:02:02', 'admin009 创建文档分类05教质业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '68', 'PC');
INSERT INTO `_activities` VALUES ('219', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:02:24', '0', '系统自动--日志', '2018-05-16 14:02:24', 'admin009 创建文档分类06就业业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '69', 'PC');
INSERT INTO `_activities` VALUES ('220', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:02:35', '0', '系统自动--日志', '2018-05-16 14:02:35', 'admin009 创建文档分类07学士后教学业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '70', 'PC');
INSERT INTO `_activities` VALUES ('221', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:03:03', '0', '系统自动--日志', '2018-05-16 14:03:03', 'admin009 创建文档分类08学士后教质业务指标图相关附件', 'com.bdqnsxt.oa.model.DocumentCategory', '71', 'PC');
INSERT INTO `_activities` VALUES ('222', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:04:09', '0', '系统自动--日志', '2018-05-16 14:04:09', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '72', 'PC');
INSERT INTO `_activities` VALUES ('223', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:04:24', '0', '系统自动--日志', '2018-05-16 14:04:24', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '73', 'PC');
INSERT INTO `_activities` VALUES ('224', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:04:41', '0', '系统自动--日志', '2018-05-16 14:04:41', 'admin009 创建文档分类竞价专员', 'com.bdqnsxt.oa.model.DocumentCategory', '74', 'PC');
INSERT INTO `_activities` VALUES ('225', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:05:04', '0', '系统自动--日志', '2018-05-16 14:05:04', 'admin009 创建文档分类竞价专员', 'com.bdqnsxt.oa.model.DocumentCategory', '75', 'PC');
INSERT INTO `_activities` VALUES ('226', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:05:24', '0', '系统自动--日志', '2018-05-16 14:05:24', 'admin009 修改文档分类网络主管', 'com.bdqnsxt.oa.model.DocumentCategory', '75', 'PC');
INSERT INTO `_activities` VALUES ('227', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:05:44', '0', '系统自动--日志', '2018-05-16 14:05:44', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '76', 'PC');
INSERT INTO `_activities` VALUES ('228', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:05:57', '0', '系统自动--日志', '2018-05-16 14:05:57', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '77', 'PC');
INSERT INTO `_activities` VALUES ('229', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:06:09', '0', '系统自动--日志', '2018-05-16 14:06:09', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '78', 'PC');
INSERT INTO `_activities` VALUES ('230', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:06:23', '0', '系统自动--日志', '2018-05-16 14:06:23', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '79', 'PC');
INSERT INTO `_activities` VALUES ('231', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:07:27', '0', '系统自动--日志', '2018-05-16 14:07:27', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '80', 'PC');
INSERT INTO `_activities` VALUES ('232', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:07:41', '0', '系统自动--日志', '2018-05-16 14:07:41', 'admin009 创建文档分类市场活动主管', 'com.bdqnsxt.oa.model.DocumentCategory', '81', 'PC');
INSERT INTO `_activities` VALUES ('233', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:07:53', '0', '系统自动--日志', '2018-05-16 14:07:53', 'admin009 创建文档分类电话销售专员', 'com.bdqnsxt.oa.model.DocumentCategory', '82', 'PC');
INSERT INTO `_activities` VALUES ('234', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:08:23', '0', '系统自动--日志', '2018-05-16 14:08:23', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '83', 'PC');
INSERT INTO `_activities` VALUES ('235', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:08:37', '0', '系统自动--日志', '2018-05-16 14:08:37', 'admin009 创建文档分类市场活动主管', 'com.bdqnsxt.oa.model.DocumentCategory', '84', 'PC');
INSERT INTO `_activities` VALUES ('236', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:08:50', '0', '系统自动--日志', '2018-05-16 14:08:50', 'admin009 创建文档分类电话销售专员', 'com.bdqnsxt.oa.model.DocumentCategory', '85', 'PC');
INSERT INTO `_activities` VALUES ('237', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:09:22', '0', '系统自动--日志', '2018-05-16 14:09:22', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '86', 'PC');
INSERT INTO `_activities` VALUES ('238', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:11:53', '0', '系统自动--日志', '2018-05-16 14:11:53', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '87', 'PC');
INSERT INTO `_activities` VALUES ('239', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:13:00', '0', '系统自动--日志', '2018-05-16 14:13:00', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '88', 'PC');
INSERT INTO `_activities` VALUES ('240', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:16:42', '0', '系统自动--日志', '2018-05-16 14:16:42', 'admin009 创建文档分类aa', 'com.bdqnsxt.oa.model.DocumentCategory', '89', 'PC');
INSERT INTO `_activities` VALUES ('241', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 14:16:54', '0', '系统自动--日志', '2018-05-16 14:16:54', 'admin009 删除文档分类aa', 'com.bdqnsxt.oa.model.DocumentCategory', '89', 'PC');
INSERT INTO `_activities` VALUES ('242', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:22:22', '0', '系统自动--日志', '2018-05-16 14:22:22', 'admin009 创建文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '90', 'PC');
INSERT INTO `_activities` VALUES ('243', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:23:00', '0', '系统自动--日志', '2018-05-16 14:23:00', 'admin009 修改文档分类aaabb', 'com.bdqnsxt.oa.model.DocumentCategory', '90', 'PC');
INSERT INTO `_activities` VALUES ('244', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:23:22', '0', '系统自动--日志', '2018-05-16 14:23:22', 'admin009 修改文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '90', 'PC');
INSERT INTO `_activities` VALUES ('245', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 14:25:36', '0', '系统自动--日志', '2018-05-16 14:25:36', 'admin009 删除文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '90', 'PC');
INSERT INTO `_activities` VALUES ('246', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:26:50', '0', '系统自动--日志', '2018-05-16 14:26:50', 'admin009 创建文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '91', 'PC');
INSERT INTO `_activities` VALUES ('247', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 14:27:05', '0', '系统自动--日志', '2018-05-16 14:27:05', 'admin009 删除文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '91', 'PC');
INSERT INTO `_activities` VALUES ('248', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 14:35:54', '0', '系统自动--日志', '2018-05-16 14:35:54', 'admin009 创建文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('249', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:36:36', '0', '系统自动--日志', '2018-05-16 14:36:36', 'admin009 修改文档分类aaabbb', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('250', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:38:49', '0', '系统自动--日志', '2018-05-16 14:38:49', 'admin009 修改文档分类aaabbbc', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('251', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:39:12', '0', '系统自动--日志', '2018-05-16 14:39:12', 'admin009 修改文档分类a', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('252', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:39:27', '0', '系统自动--日志', '2018-05-16 14:39:27', 'admin009 修改文档分类a]', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('253', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:41:02', '0', '系统自动--日志', '2018-05-16 14:41:02', 'admin009 修改文档分类a]b', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('254', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:44:12', '0', '系统自动--日志', '2018-05-16 14:44:12', 'admin009 修改文档分类a]bc', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('255', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:45:36', '0', '系统自动--日志', '2018-05-16 14:45:36', 'admin009 修改文档分类a]bcd', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('256', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:45:52', '0', '系统自动--日志', '2018-05-16 14:45:52', 'admin009 修改文档分类a', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('257', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:52:19', '0', '系统自动--日志', '2018-05-16 14:52:19', 'admin009 修改文档分类ab', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('258', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:53:29', '0', '系统自动--日志', '2018-05-16 14:53:29', 'admin009 修改文档分类ab~', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('259', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:54:37', '0', '系统自动--日志', '2018-05-16 14:54:37', 'admin009 修改文档分类ab~!', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('260', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 14:58:54', '0', '系统自动--日志', '2018-05-16 14:58:54', 'admin009 修改文档分类ab~!1', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('261', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:05:33', '0', '系统自动--日志', '2018-05-16 15:05:33', 'admin009 修改文档分类ab~!11', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('262', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:07:03', '0', '系统自动--日志', '2018-05-16 15:07:03', 'admin009 修改文档分类ab~!111', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('263', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:13:42', '0', '系统自动--日志', '2018-05-16 15:13:42', 'admin009 修改文档分类ab~!1111', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('264', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:14:43', '0', '系统自动--日志', '2018-05-16 15:14:43', 'admin009 修改文档分类ab~!11111', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('265', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:16:13', '0', '系统自动--日志', '2018-05-16 15:16:13', 'admin009 修改文档分类ab~!11111~', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('266', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:19:41', '0', '系统自动--日志', '2018-05-16 15:19:41', 'admin009 修改文档分类abc', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('267', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:22:13', '0', '系统自动--日志', '2018-05-16 15:22:13', 'admin009 修改文档分类abcd', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('268', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:23:48', '0', '系统自动--日志', '2018-05-16 15:23:48', 'admin009 修改文档分类abcd]', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('269', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:25:24', '0', '系统自动--日志', '2018-05-16 15:25:24', 'admin009 修改文档分类abcd]~', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('270', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:25:44', '0', '系统自动--日志', '2018-05-16 15:25:44', 'admin009 修改文档分类abcd]~1', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('271', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:27:00', '0', '系统自动--日志', '2018-05-16 15:27:00', 'admin009 修改文档分类abcd]~11', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('272', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:35:38', '0', '系统自动--日志', '2018-05-16 15:35:38', 'admin009 修改文档分类abcd]~11``', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('273', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-16 15:41:22', '0', '系统自动--日志', '2018-05-16 15:41:22', 'admin009 修改文档分类abcd]~11``11', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('274', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 15:42:44', '0', '系统自动--日志', '2018-05-16 15:42:44', 'admin009 删除文档分类abcd]~11``11', 'com.bdqnsxt.oa.model.DocumentCategory', '92', 'PC');
INSERT INTO `_activities` VALUES ('275', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:42:51', '0', '系统自动--日志', '2018-05-16 15:42:51', 'admin009 创建文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '93', 'PC');
INSERT INTO `_activities` VALUES ('276', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 15:53:13', '0', '系统自动--日志', '2018-05-16 15:53:13', 'admin009 删除文档分类aaa', 'com.bdqnsxt.oa.model.DocumentCategory', '93', 'PC');
INSERT INTO `_activities` VALUES ('277', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:53:35', '0', '系统自动--日志', '2018-05-16 15:53:35', 'admin009 创建文档分类咨询师', 'com.bdqnsxt.oa.model.DocumentCategory', '94', 'PC');
INSERT INTO `_activities` VALUES ('278', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:55:51', '0', '系统自动--日志', '2018-05-16 15:55:51', 'admin009 创建文档分类咨询助理', 'com.bdqnsxt.oa.model.DocumentCategory', '95', 'PC');
INSERT INTO `_activities` VALUES ('279', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:56:07', '0', '系统自动--日志', '2018-05-16 15:56:07', 'admin009 创建文档分类咨询主管', 'com.bdqnsxt.oa.model.DocumentCategory', '96', 'PC');
INSERT INTO `_activities` VALUES ('280', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:56:28', '0', '系统自动--日志', '2018-05-16 15:56:28', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '97', 'PC');
INSERT INTO `_activities` VALUES ('281', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:56:38', '0', '系统自动--日志', '2018-05-16 15:56:38', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '98', 'PC');
INSERT INTO `_activities` VALUES ('282', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:56:51', '0', '系统自动--日志', '2018-05-16 15:56:51', 'admin009 创建文档分类学术部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '99', 'PC');
INSERT INTO `_activities` VALUES ('283', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:57:15', '0', '系统自动--日志', '2018-05-16 15:57:15', 'admin009 创建文档分类教员', 'com.bdqnsxt.oa.model.DocumentCategory', '100', 'PC');
INSERT INTO `_activities` VALUES ('284', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:57:36', '0', '系统自动--日志', '2018-05-16 15:57:36', 'admin009 创建文档分类学术部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '101', 'PC');
INSERT INTO `_activities` VALUES ('285', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:57:53', '0', '系统自动--日志', '2018-05-16 15:57:53', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '102', 'PC');
INSERT INTO `_activities` VALUES ('286', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:58:03', '0', '系统自动--日志', '2018-05-16 15:58:03', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '103', 'PC');
INSERT INTO `_activities` VALUES ('287', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:58:14', '0', '系统自动--日志', '2018-05-16 15:58:14', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '104', 'PC');
INSERT INTO `_activities` VALUES ('288', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:58:36', '0', '系统自动--日志', '2018-05-16 15:58:36', 'admin009 创建文档分类教质部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '105', 'PC');
INSERT INTO `_activities` VALUES ('289', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:58:48', '0', '系统自动--日志', '2018-05-16 15:58:48', 'admin009 创建文档分类班主任', 'com.bdqnsxt.oa.model.DocumentCategory', '106', 'PC');
INSERT INTO `_activities` VALUES ('290', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:59:07', '0', '系统自动--日志', '2018-05-16 15:59:07', 'admin009 创建文档分类班主任', 'com.bdqnsxt.oa.model.DocumentCategory', '107', 'PC');
INSERT INTO `_activities` VALUES ('291', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:59:18', '0', '系统自动--日志', '2018-05-16 15:59:18', 'admin009 创建文档分类教质部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '108', 'PC');
INSERT INTO `_activities` VALUES ('292', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:59:36', '0', '系统自动--日志', '2018-05-16 15:59:36', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '109', 'PC');
INSERT INTO `_activities` VALUES ('293', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:59:48', '0', '系统自动--日志', '2018-05-16 15:59:48', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '110', 'PC');
INSERT INTO `_activities` VALUES ('294', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 15:59:57', '0', '系统自动--日志', '2018-05-16 15:59:57', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '111', 'PC');
INSERT INTO `_activities` VALUES ('295', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:00:08', '0', '系统自动--日志', '2018-05-16 16:00:08', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '112', 'PC');
INSERT INTO `_activities` VALUES ('296', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:00:16', '0', '系统自动--日志', '2018-05-16 16:00:16', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '113', 'PC');
INSERT INTO `_activities` VALUES ('297', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:00:31', '0', '系统自动--日志', '2018-05-16 16:00:31', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '114', 'PC');
INSERT INTO `_activities` VALUES ('298', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:00:40', '0', '系统自动--日志', '2018-05-16 16:00:40', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '115', 'PC');
INSERT INTO `_activities` VALUES ('299', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:00:54', '0', '系统自动--日志', '2018-05-16 16:00:54', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '116', 'PC');
INSERT INTO `_activities` VALUES ('300', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:01:03', '0', '系统自动--日志', '2018-05-16 16:01:03', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '117', 'PC');
INSERT INTO `_activities` VALUES ('301', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:01:23', '0', '系统自动--日志', '2018-05-16 16:01:23', 'admin009 创建文档分类基础数据表-技术顾问', 'com.bdqnsxt.oa.model.DocumentCategory', '118', 'PC');
INSERT INTO `_activities` VALUES ('302', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:02:03', '0', '系统自动--日志', '2018-05-16 16:02:03', 'admin009 创建文档分类基础数据表-辅导员', 'com.bdqnsxt.oa.model.DocumentCategory', '119', 'PC');
INSERT INTO `_activities` VALUES ('303', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:03:50', '0', '系统自动--日志', '2018-05-16 16:03:50', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '120', 'PC');
INSERT INTO `_activities` VALUES ('304', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:04:19', '0', '系统自动--日志', '2018-05-16 16:04:19', 'admin009 创建文档分类竞价专员', 'com.bdqnsxt.oa.model.DocumentCategory', '121', 'PC');
INSERT INTO `_activities` VALUES ('305', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:04:30', '0', '系统自动--日志', '2018-05-16 16:04:30', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '122', 'PC');
INSERT INTO `_activities` VALUES ('306', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:04:42', '0', '系统自动--日志', '2018-05-16 16:04:42', 'admin009 创建文档分类网络主管', 'com.bdqnsxt.oa.model.DocumentCategory', '123', 'PC');
INSERT INTO `_activities` VALUES ('307', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:06:12', '0', '系统自动--日志', '2018-05-16 16:06:12', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '124', 'PC');
INSERT INTO `_activities` VALUES ('308', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:06:22', '0', '系统自动--日志', '2018-05-16 16:06:22', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '125', 'PC');
INSERT INTO `_activities` VALUES ('309', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:06:30', '0', '系统自动--日志', '2018-05-16 16:06:30', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '126', 'PC');
INSERT INTO `_activities` VALUES ('310', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:06:51', '0', '系统自动--日志', '2018-05-16 16:06:51', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '127', 'PC');
INSERT INTO `_activities` VALUES ('311', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:07:44', '0', '系统自动--日志', '2018-05-16 16:07:44', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '128', 'PC');
INSERT INTO `_activities` VALUES ('312', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:07:52', '0', '系统自动--日志', '2018-05-16 16:07:52', 'admin009 创建文档分类市场活动主管', 'com.bdqnsxt.oa.model.DocumentCategory', '129', 'PC');
INSERT INTO `_activities` VALUES ('313', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:08:00', '0', '系统自动--日志', '2018-05-16 16:08:00', 'admin009 创建文档分类电话销售专员', 'com.bdqnsxt.oa.model.DocumentCategory', '130', 'PC');
INSERT INTO `_activities` VALUES ('314', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:08:13', '0', '系统自动--日志', '2018-05-16 16:08:13', 'admin009 创建文档分类市场活动专员', 'com.bdqnsxt.oa.model.DocumentCategory', '131', 'PC');
INSERT INTO `_activities` VALUES ('315', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:08:24', '0', '系统自动--日志', '2018-05-16 16:08:24', 'admin009 创建文档分类市场活动主管', 'com.bdqnsxt.oa.model.DocumentCategory', '132', 'PC');
INSERT INTO `_activities` VALUES ('316', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:08:44', '0', '系统自动--日志', '2018-05-16 16:08:44', 'admin009 创建文档分类电话销售专员', 'com.bdqnsxt.oa.model.DocumentCategory', '133', 'PC');
INSERT INTO `_activities` VALUES ('317', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:09:49', '0', '系统自动--日志', '2018-05-16 16:09:49', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '134', 'PC');
INSERT INTO `_activities` VALUES ('318', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:09:58', '0', '系统自动--日志', '2018-05-16 16:09:58', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '135', 'PC');
INSERT INTO `_activities` VALUES ('319', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:10:08', '0', '系统自动--日志', '2018-05-16 16:10:08', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '136', 'PC');
INSERT INTO `_activities` VALUES ('320', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:10:44', '0', '系统自动--日志', '2018-05-16 16:10:44', 'admin009 创建文档分类咨询师', 'com.bdqnsxt.oa.model.DocumentCategory', '137', 'PC');
INSERT INTO `_activities` VALUES ('321', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:11:02', '0', '系统自动--日志', '2018-05-16 16:11:02', 'admin009 创建文档分类咨询助理', 'com.bdqnsxt.oa.model.DocumentCategory', '138', 'PC');
INSERT INTO `_activities` VALUES ('322', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:11:21', '0', '系统自动--日志', '2018-05-16 16:11:21', 'admin009 创建文档分类咨询主管', 'com.bdqnsxt.oa.model.DocumentCategory', '139', 'PC');
INSERT INTO `_activities` VALUES ('323', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:12:31', '0', '系统自动--日志', '2018-05-16 16:12:31', 'admin009 创建文档分类基础数据表-技术顾问', 'com.bdqnsxt.oa.model.DocumentCategory', '140', 'PC');
INSERT INTO `_activities` VALUES ('324', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:12:48', '0', '系统自动--日志', '2018-05-16 16:12:48', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '141', 'PC');
INSERT INTO `_activities` VALUES ('325', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:13:00', '0', '系统自动--日志', '2018-05-16 16:13:00', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '142', 'PC');
INSERT INTO `_activities` VALUES ('326', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:13:10', '0', '系统自动--日志', '2018-05-16 16:13:10', 'admin009 创建文档分类学术部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '143', 'PC');
INSERT INTO `_activities` VALUES ('327', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:13:26', '0', '系统自动--日志', '2018-05-16 16:13:26', 'admin009 创建文档分类教员', 'com.bdqnsxt.oa.model.DocumentCategory', '144', 'PC');
INSERT INTO `_activities` VALUES ('328', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:13:42', '0', '系统自动--日志', '2018-05-16 16:13:42', 'admin009 创建文档分类学术部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '145', 'PC');
INSERT INTO `_activities` VALUES ('329', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:14:46', '0', '系统自动--日志', '2018-05-16 16:14:46', 'admin009 创建文档分类基础数据表-辅导员', 'com.bdqnsxt.oa.model.DocumentCategory', '146', 'PC');
INSERT INTO `_activities` VALUES ('330', 'ObjectDelete', '0', '系统自动--日志', '2018-05-16 16:15:08', '0', '系统自动--日志', '2018-05-16 16:15:08', 'admin009 删除文档分类基础数据表-辅导员', 'com.bdqnsxt.oa.model.DocumentCategory', '146', 'PC');
INSERT INTO `_activities` VALUES ('331', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:15:23', '0', '系统自动--日志', '2018-05-16 16:15:23', 'admin009 创建文档分类基础数据表-辅导员', 'com.bdqnsxt.oa.model.DocumentCategory', '147', 'PC');
INSERT INTO `_activities` VALUES ('332', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:15:38', '0', '系统自动--日志', '2018-05-16 16:15:38', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '148', 'PC');
INSERT INTO `_activities` VALUES ('333', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:15:48', '0', '系统自动--日志', '2018-05-16 16:15:48', 'admin009 创建文档分类教质部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '149', 'PC');
INSERT INTO `_activities` VALUES ('334', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:15:57', '0', '系统自动--日志', '2018-05-16 16:15:57', 'admin009 创建文档分类班主任', 'com.bdqnsxt.oa.model.DocumentCategory', '150', 'PC');
INSERT INTO `_activities` VALUES ('335', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:16:14', '0', '系统自动--日志', '2018-05-16 16:16:14', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '151', 'PC');
INSERT INTO `_activities` VALUES ('336', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:16:24', '0', '系统自动--日志', '2018-05-16 16:16:24', 'admin009 创建文档分类班主任', 'com.bdqnsxt.oa.model.DocumentCategory', '152', 'PC');
INSERT INTO `_activities` VALUES ('337', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:16:37', '0', '系统自动--日志', '2018-05-16 16:16:37', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '153', 'PC');
INSERT INTO `_activities` VALUES ('338', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:16:49', '0', '系统自动--日志', '2018-05-16 16:16:49', 'admin009 创建文档分类教质部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '154', 'PC');
INSERT INTO `_activities` VALUES ('339', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:17:36', '0', '系统自动--日志', '2018-05-16 16:17:36', 'admin009 创建文档分类原始记录单', 'com.bdqnsxt.oa.model.DocumentCategory', '155', 'PC');
INSERT INTO `_activities` VALUES ('340', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:17:47', '0', '系统自动--日志', '2018-05-16 16:17:47', 'admin009 创建文档分类基础数据表', 'com.bdqnsxt.oa.model.DocumentCategory', '156', 'PC');
INSERT INTO `_activities` VALUES ('341', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:17:55', '0', '系统自动--日志', '2018-05-16 16:17:55', 'admin009 创建文档分类分析数据表及PPT', 'com.bdqnsxt.oa.model.DocumentCategory', '157', 'PC');
INSERT INTO `_activities` VALUES ('342', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:07', '0', '系统自动--日志', '2018-05-16 16:18:07', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '158', 'PC');
INSERT INTO `_activities` VALUES ('343', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:17', '0', '系统自动--日志', '2018-05-16 16:18:17', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '159', 'PC');
INSERT INTO `_activities` VALUES ('344', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:29', '0', '系统自动--日志', '2018-05-16 16:18:29', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '160', 'PC');
INSERT INTO `_activities` VALUES ('345', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:38', '0', '系统自动--日志', '2018-05-16 16:18:38', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '161', 'PC');
INSERT INTO `_activities` VALUES ('346', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:50', '0', '系统自动--日志', '2018-05-16 16:18:50', 'admin009 创建文档分类就业专员', 'com.bdqnsxt.oa.model.DocumentCategory', '162', 'PC');
INSERT INTO `_activities` VALUES ('347', 'ObjectCreate', '0', '系统自动--日志', '2018-05-16 16:18:59', '0', '系统自动--日志', '2018-05-16 16:18:59', 'admin009 创建文档分类就业部经理', 'com.bdqnsxt.oa.model.DocumentCategory', '163', 'PC');
INSERT INTO `_activities` VALUES ('348', 'ObjectCreate', '0', '系统自动--日志', '2018-05-17 15:56:07', '0', '系统自动--日志', '2018-05-17 15:56:07', 'admin009 创建模板附件7-1：网络宣传关键词词库.xls', 'com.bdqnsxt.oa.model.Document', '166', 'PC');
INSERT INTO `_activities` VALUES ('349', 'ObjectCreate', '0', '系统自动--日志', '2018-05-17 16:45:43', '0', '系统自动--日志', '2018-05-17 16:45:43', 'admin009 创建模板附件2-1：网络推广月度总结计划报告20131121.ppt', 'com.bdqnsxt.oa.model.Document', '167', 'PC');
INSERT INTO `_activities` VALUES ('350', 'ObjectDelete', '0', '系统自动--日志', '2018-05-18 09:47:01', '0', '系统自动--日志', '2018-05-18 09:47:01', 'admin009 删除', 'com.bdqnsxt.oa.model.Document', '167', 'PC');
INSERT INTO `_activities` VALUES ('351', 'ObjectCreate', '0', '系统自动--日志', '2018-05-18 10:05:14', '0', '系统自动--日志', '2018-05-18 10:05:14', 'admin009 创建模板附件2-1：付费网络推广月度总结计划（竞价专员）20131120.ppt', 'com.bdqnsxt.oa.model.Document', '168', 'PC');
INSERT INTO `_activities` VALUES ('352', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:11:44', '0', '系统自动--日志', '2018-05-18 11:11:44', 'admin009 上传模板中心校长岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '169', 'PC');
INSERT INTO `_activities` VALUES ('353', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:18:09', '0', '系统自动--日志', '2018-05-18 11:18:09', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '171', 'PC');
INSERT INTO `_activities` VALUES ('354', 'ObjectDelete', '0', '系统自动--日志', '2018-05-18 11:20:11', '0', '系统自动--日志', '2018-05-18 11:20:11', 'admin009 删除', 'com.bdqnsxt.oa.model.Document', '171', 'PC');
INSERT INTO `_activities` VALUES ('355', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:20:35', '0', '系统自动--日志', '2018-05-18 11:20:35', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '172', 'PC');
INSERT INTO `_activities` VALUES ('356', 'ObjectDelete', '0', '系统自动--日志', '2018-05-18 11:27:58', '0', '系统自动--日志', '2018-05-18 11:27:58', 'admin009 删除', 'com.bdqnsxt.oa.model.Document', '172', 'PC');
INSERT INTO `_activities` VALUES ('357', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:29:40', '0', '系统自动--日志', '2018-05-18 11:29:40', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '173', 'PC');
INSERT INTO `_activities` VALUES ('358', 'ObjectDelete', '0', '系统自动--日志', '2018-05-18 11:30:12', '0', '系统自动--日志', '2018-05-18 11:30:12', 'admin009 删除', 'com.bdqnsxt.oa.model.Document', '173', 'PC');
INSERT INTO `_activities` VALUES ('359', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:33:09', '0', '系统自动--日志', '2018-05-18 11:33:09', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '174', 'PC');
INSERT INTO `_activities` VALUES ('360', 'ObjectDelete', '0', '系统自动--日志', '2018-05-18 11:33:22', '0', '系统自动--日志', '2018-05-18 11:33:22', 'admin009 删除模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '174', 'PC');
INSERT INTO `_activities` VALUES ('361', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 11:47:19', '0', '系统自动--日志', '2018-05-18 11:47:19', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '175', 'PC');
INSERT INTO `_activities` VALUES ('362', 'ObjectUpload', '0', '系统自动--日志', '2018-05-18 16:20:23', '0', '系统自动--日志', '2018-05-18 16:20:23', 'admin009 上传模板竞价专员岗位附件列表.xlsx', 'com.bdqnsxt.oa.model.Document', '176', 'PC');
INSERT INTO `_activities` VALUES ('363', 'ObjectCreate', '0', '系统自动--日志', '2018-05-19 08:55:55', '0', '系统自动--日志', '2018-05-19 08:55:55', 'admin009 创建模板分类测试分类', 'com.bdqnsxt.oa.model.DocumentCategory', '164', 'PC');
INSERT INTO `_activities` VALUES ('364', 'ObjectCreate', '0', '系统自动--日志', '2018-05-19 08:56:09', '0', '系统自动--日志', '2018-05-19 08:56:09', 'admin009 创建模板分类分类的分类', 'com.bdqnsxt.oa.model.DocumentCategory', '165', 'PC');
INSERT INTO `_activities` VALUES ('365', 'ObjectDelete', '0', '系统自动--日志', '2018-05-19 08:56:20', '0', '系统自动--日志', '2018-05-19 08:56:20', 'admin009 删除模板分类分类的分类', 'com.bdqnsxt.oa.model.DocumentCategory', '165', 'PC');
INSERT INTO `_activities` VALUES ('366', 'ObjectDelete', '0', '系统自动--日志', '2018-05-19 08:56:26', '0', '系统自动--日志', '2018-05-19 08:56:26', 'admin009 删除模板分类测试分类', 'com.bdqnsxt.oa.model.DocumentCategory', '164', 'PC');
INSERT INTO `_activities` VALUES ('367', 'ObjectUpload', '0', '系统自动--日志', '2018-05-19 08:59:25', '0', '系统自动--日志', '2018-05-19 08:59:25', 'admin009 上传模板场地考察记录.doc', 'com.bdqnsxt.oa.model.Document', '177', 'PC');
INSERT INTO `_activities` VALUES ('368', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:28:19', '0', '系统自动--日志', '2018-05-19 09:28:19', 'admin009 修改菜单权限岗位id为2002', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('369', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:28:27', '0', '系统自动--日志', '2018-05-19 09:28:27', 'admin009 修改菜单权限岗位id为2002', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('370', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:28:51', '0', '系统自动--日志', '2018-05-19 09:28:51', 'admin009 修改菜单权限岗位id为2027', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('371', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:28:59', '0', '系统自动--日志', '2018-05-19 09:28:59', 'admin009 修改菜单权限岗位id为2037', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('372', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:29:18', '0', '系统自动--日志', '2018-05-19 09:29:18', 'admin009 修改菜单权限岗位id为2014', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('373', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 09:40:38', '0', '系统自动--日志', '2018-05-19 09:40:38', 'admin009 修改用户wq2018', 'com.bdqnsxt.oa.model.User', '10', 'PC');
INSERT INTO `_activities` VALUES ('374', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 13:39:07', '0', '系统自动--日志', '2018-05-19 13:39:07', 'admin008 修改用户admin008', 'com.bdqnsxt.oa.model.User', '16', 'PC');
INSERT INTO `_activities` VALUES ('375', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:03:20', '0', '系统自动--日志', '2018-05-19 15:03:20', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('376', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:42:21', '0', '系统自动--日志', '2018-05-19 15:42:21', 'admin009 修改菜单权限岗位id为2002', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('377', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:44:06', '0', '系统自动--日志', '2018-05-19 15:44:06', 'admin009 修改菜单权限岗位id为2017', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('378', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:44:49', '0', '系统自动--日志', '2018-05-19 15:44:49', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('379', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:45:16', '0', '系统自动--日志', '2018-05-19 15:45:16', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('380', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-19 15:55:00', '0', '系统自动--日志', '2018-05-19 15:55:00', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('381', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 11:07:14', '0', '系统自动--日志', '2018-05-21 11:07:14', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('382', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:15:45', '0', '系统自动--日志', '2018-05-21 12:15:45', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('383', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:17:12', '0', '系统自动--日志', '2018-05-21 12:17:12', 'admin009 修改用户wq2018', 'com.bdqnsxt.oa.model.User', '10', 'PC');
INSERT INTO `_activities` VALUES ('384', 'ObjectCreate', '0', '系统自动--日志', '2018-05-21 12:18:37', '0', '系统自动--日志', '2018-05-21 12:18:37', 'admin009 创建学生小马哥', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('385', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:19:03', '0', '系统自动--日志', '2018-05-21 12:19:03', 'admin009 修改学生小马哥123', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('386', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:19:42', '0', '系统自动--日志', '2018-05-21 12:19:42', 'admin009 修改学生小马哥', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('387', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:21:20', '0', '系统自动--日志', '2018-05-21 12:21:20', 'admin009 修改学生小马哥123', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('388', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:22:13', '0', '系统自动--日志', '2018-05-21 12:22:13', 'admin009 修改学生小马哥123', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('389', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 12:26:59', '0', '系统自动--日志', '2018-05-21 12:26:59', 'wq2000 修改学生小马哥', 'com.bdqnsxt.oa.model.Student', '7', 'PC');
INSERT INTO `_activities` VALUES ('390', 'ObjectCreate', '0', '系统自动--日志', '2018-05-21 12:29:29', '0', '系统自动--日志', '2018-05-21 12:29:29', 'admin009 创建模板分类test', 'com.bdqnsxt.oa.model.DocumentCategory', '166', 'PC');
INSERT INTO `_activities` VALUES ('391', 'ObjectCreate', '0', '系统自动--日志', '2018-05-21 13:41:56', '0', '系统自动--日志', '2018-05-21 13:41:56', 'wq2000 创建学员咨询<wq2000(丁老师)> : <小马哥(13793415312)>', 'com.bdqnsxt.oa.model.StudentConsult', '0', 'PC');
INSERT INTO `_activities` VALUES ('392', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 14:53:49', '0', '系统自动--日志', '2018-05-21 14:53:49', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('393', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 16:42:43', '0', '系统自动--日志', '2018-05-21 16:42:43', 'admin009 修改用户szcvsdf', 'com.bdqnsxt.oa.model.User', '13', 'PC');
INSERT INTO `_activities` VALUES ('394', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 16:45:32', '0', '系统自动--日志', '2018-05-21 16:45:32', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('395', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 16:45:45', '0', '系统自动--日志', '2018-05-21 16:45:45', 'admin009 修改用户wq2000', 'com.bdqnsxt.oa.model.User', '12', 'PC');
INSERT INTO `_activities` VALUES ('396', 'ObjectCreate', '0', '系统自动--日志', '2018-05-21 16:46:28', '0', '系统自动--日志', '2018-05-21 16:46:28', 'admin009 创建用户wq2001', 'com.bdqnsxt.oa.model.User', '20', 'PC');
INSERT INTO `_activities` VALUES ('397', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-21 16:47:14', '0', '系统自动--日志', '2018-05-21 16:47:14', 'admin009 修改菜单权限岗位id为2018', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('398', 'ObjectCreate', '0', '系统自动--日志', '2018-05-21 16:48:01', '0', '系统自动--日志', '2018-05-21 16:48:01', 'wq2001 创建学员咨询<wq2001(张海燕)> : <小马哥(13793415312)>', 'com.bdqnsxt.oa.model.StudentConsult', '0', 'PC');
INSERT INTO `_activities` VALUES ('399', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 14:53:38', '0', '系统自动--日志', '2018-05-22 14:53:38', 'wq2000 创建学员咨询<wq2000(丁虹)> : <李磊(13712312311)>', 'com.bdqnsxt.oa.model.StudentConsult', '0', 'PC');
INSERT INTO `_activities` VALUES ('400', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-22 14:57:17', '0', '系统自动--日志', '2018-05-22 14:57:17', 'admin009 修改菜单权限岗位id为2017', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('401', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 15:04:04', '0', '系统自动--日志', '2018-05-22 15:04:04', 'wq2000 创建学员咨询<wq2000(丁虹)> : <小马哥(13793415312)>', 'com.bdqnsxt.oa.model.StudentConsult', '0', 'PC');
INSERT INTO `_activities` VALUES ('402', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 15:14:31', '0', '系统自动--日志', '2018-05-22 15:14:31', 'admin009 创建学生李凡', 'com.bdqnsxt.oa.model.Student', '8', 'PC');
INSERT INTO `_activities` VALUES ('403', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 15:15:00', '0', '系统自动--日志', '2018-05-22 15:15:00', 'wq2000 创建学员咨询<wq2000(丁虹)> : <李凡(15975424321)>', 'com.bdqnsxt.oa.model.StudentConsult', '0', 'PC');
INSERT INTO `_activities` VALUES ('404', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-22 16:14:45', '0', '系统自动--日志', '2018-05-22 16:14:45', 'admin009 修改菜单权限岗位id为2018', 'com.bdqnsxt.oa.model.RoleMenu', '0', 'PC');
INSERT INTO `_activities` VALUES ('405', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 16:17:47', '0', '系统自动--日志', '2018-05-22 16:17:47', 'admin009 创建学生李勇', 'com.bdqnsxt.oa.model.Student', '9', 'PC');
INSERT INTO `_activities` VALUES ('406', 'ObjectCreate', '0', '系统自动--日志', '2018-05-22 16:18:15', '0', '系统自动--日志', '2018-05-22 16:18:15', 'wq2001 创建学员咨询<wq2001(张海燕)> : <李勇(15612443141)>', 'com.bdqnsxt.oa.model.StudentConsult', '4', 'PC');
INSERT INTO `_activities` VALUES ('407', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:42:55', '0', '系统自动--日志', '2018-05-23 10:42:55', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('408', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:44:54', '0', '系统自动--日志', '2018-05-23 10:44:54', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('409', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:45:22', '0', '系统自动--日志', '2018-05-23 10:45:22', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('410', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:46:22', '0', '系统自动--日志', '2018-05-23 10:46:22', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('411', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:48:15', '0', '系统自动--日志', '2018-05-23 10:48:15', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('412', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 10:51:35', '0', '系统自动--日志', '2018-05-23 10:51:35', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('413', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 11:05:35', '0', '系统自动--日志', '2018-05-23 11:05:35', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('414', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 11:45:58', '0', '系统自动--日志', '2018-05-23 11:45:58', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('415', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 11:50:03', '0', '系统自动--日志', '2018-05-23 11:50:03', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('416', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 11:58:30', '0', '系统自动--日志', '2018-05-23 11:58:30', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('417', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 12:22:22', '0', '系统自动--日志', '2018-05-23 12:22:22', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('418', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 12:22:40', '0', '系统自动--日志', '2018-05-23 12:22:40', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('419', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 13:25:09', '0', '系统自动--日志', '2018-05-23 13:25:09', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('420', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 13:37:07', '0', '系统自动--日志', '2018-05-23 13:37:07', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('421', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 13:48:26', '0', '系统自动--日志', '2018-05-23 13:48:26', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('422', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 13:54:13', '0', '系统自动--日志', '2018-05-23 13:54:13', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('423', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 13:55:05', '0', '系统自动--日志', '2018-05-23 13:55:05', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('424', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 14:10:44', '0', '系统自动--日志', '2018-05-23 14:10:44', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('425', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 14:14:28', '0', '系统自动--日志', '2018-05-23 14:14:28', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('426', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 14:17:15', '0', '系统自动--日志', '2018-05-23 14:17:15', 'wq2000 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('427', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 14:38:31', '0', '系统自动--日志', '2018-05-23 14:38:31', 'admin009 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('428', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 15:30:26', '0', '系统自动--日志', '2018-05-23 15:30:26', 'admin009 修改用户wq2019', 'com.bdqnsxt.oa.model.User', '11', 'PC');
INSERT INTO `_activities` VALUES ('429', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 15:43:56', '0', '系统自动--日志', '2018-05-23 15:43:56', 'admin009 修改班级济南校区01期', 'com.bdqnsxt.oa.model.Clazz', '1', 'PC');
INSERT INTO `_activities` VALUES ('430', 'ObjectUpload', '0', '系统自动--日志', '2018-05-23 15:46:56', '0', '系统自动--日志', '2018-05-23 15:46:56', 'admin009 上传模板附件1-1：中心年度利润总结.xls', 'com.bdqnsxt.oa.model.Document', '178', 'PC');
INSERT INTO `_activities` VALUES ('431', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 15:48:03', '0', '系统自动--日志', '2018-05-23 15:48:03', 'admin009 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('432', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:04:18', '0', '系统自动--日志', '2018-05-23 16:04:18', 'admin009 修改学员咨询<null(null)> : <null(null)>', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('433', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:27:43', '0', '系统自动--日志', '2018-05-23 16:27:43', 'wq2000 修改学员咨询<null(null)> : <null(null)>;锁定时间：2018-05-23 16:27:43;面试时间：2018-05-15 16:27:37;一次回访：1;二次回访：2;三次回访：3;备注：4', 'com.bdqnsxt.oa.model.StudentConsult', '4', 'PC');
INSERT INTO `_activities` VALUES ('434', 'ObjectCreate', '0', '系统自动--日志', '2018-05-23 16:29:47', '0', '系统自动--日志', '2018-05-23 16:29:47', 'wq2000 创建学生test007', 'com.bdqnsxt.oa.model.Student', '10', 'PC');
INSERT INTO `_activities` VALUES ('435', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:30:38', '0', '系统自动--日志', '2018-05-23 16:30:38', 'admin009 修改学生test007', 'com.bdqnsxt.oa.model.Student', '10', 'PC');
INSERT INTO `_activities` VALUES ('437', 'ObjectCreate', '0', '系统自动--日志', '2018-05-23 16:42:45', '0', '系统自动--日志', '2018-05-23 16:42:45', 'wq2000 创建学员咨询<wq2000(丁虹)> : <李勇(15612443141)>;一次回访：null;二次回访：null;三次回访：null;备注：null;锁定时间：2018-05-23 16:42:45', 'com.bdqnsxt.oa.model.StudentConsult', '6', 'PC');
INSERT INTO `_activities` VALUES ('438', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:43:36', '0', '系统自动--日志', '2018-05-23 16:43:36', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：5;二次回访：6;三次回访：7;备注：8;锁定时间：2018-05-23 16:43:36;面试时间：2018-05-23 16:43:28', 'com.bdqnsxt.oa.model.StudentConsult', '6', 'PC');
INSERT INTO `_activities` VALUES ('439', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:44:40', '0', '系统自动--日志', '2018-05-23 16:44:40', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：5;二次回访：4;三次回访：3;备注：2;锁定时间：2018-05-23 16:44:40;面试时间：2018-05-23 16:44:33', 'com.bdqnsxt.oa.model.StudentConsult', '6', 'PC');
INSERT INTO `_activities` VALUES ('440', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:52:22', '0', '系统自动--日志', '2018-05-23 16:52:22', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 16:52:22;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('441', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:54:04', '0', '系统自动--日志', '2018-05-23 16:54:04', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：;二次回访：;三次回访：;备注：;锁定时间：2018-05-23 16:54:04;面试时间：2018-05-16 16:53:59', 'com.bdqnsxt.oa.model.StudentConsult', '1', 'PC');
INSERT INTO `_activities` VALUES ('442', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:54:34', '0', '系统自动--日志', '2018-05-23 16:54:34', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 16:54:34;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('443', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:57:14', '0', '系统自动--日志', '2018-05-23 16:57:14', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 16:57:14;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('444', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 16:57:50', '0', '系统自动--日志', '2018-05-23 16:57:50', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 16:57:50;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('445', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 17:01:09', '0', '系统自动--日志', '2018-05-23 17:01:09', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 17:01:09;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('446', 'ObjectCreate', '0', '系统自动--日志', '2018-05-23 17:09:47', '0', '系统自动--日志', '2018-05-23 17:09:47', 'wq2000 创建学员咨询<wq2000(丁虹)> : <李勇(15612443141)>;一次回访：null;二次回访：null;三次回访：null;备注：null;锁定时间：2018-05-23 17:09:47', 'com.bdqnsxt.oa.model.StudentConsult', '7', 'PC');
INSERT INTO `_activities` VALUES ('447', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 17:14:01', '0', '系统自动--日志', '2018-05-23 17:14:01', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：;二次回访：;三次回访：;备注：;锁定时间：2018-05-23 17:14:01;面试时间：2018-05-10 17:13:57', 'com.bdqnsxt.oa.model.StudentConsult', '7', 'PC');
INSERT INTO `_activities` VALUES ('448', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 17:15:16', '0', '系统自动--日志', '2018-05-23 17:15:16', 'wq2000 修改学员咨询<(null)> : <(null)>;一次回访：test1;二次回访：test2;三次回访：test3;备注：test remarks;锁定时间：2018-05-23 17:15:16;面试时间：2018-05-23 14:17:12', 'com.bdqnsxt.oa.model.StudentConsult', '3', 'PC');
INSERT INTO `_activities` VALUES ('449', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-23 17:25:00', '0', '系统自动--日志', '2018-05-23 17:25:00', 'wq2000 修改学员咨询<丁虹(null)> : <小马哥(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-23 17:25:00;面试时间：2018-05-10 16:04:14', 'com.bdqnsxt.oa.model.StudentConsult', '2', 'PC');
INSERT INTO `_activities` VALUES ('450', 'ObjectDelete', '0', '系统自动--日志', '2018-05-23 17:33:23', '0', '系统自动--日志', '2018-05-23 17:33:23', 'wq2000 删除学员咨询<丁虹(null)> : <李磊(null)>;一次回访：;二次回访：;三次回访：;备注：;面试时间：2018-05-16 16:53:59', 'com.bdqnsxt.oa.model.StudentConsult', '1', 'PC');
INSERT INTO `_activities` VALUES ('451', 'ObjectCreate', '0', '系统自动--日志', '2018-05-25 12:03:16', '0', '系统自动--日志', '2018-05-25 12:03:16', 'admin009 创建学生test008', 'com.bdqnsxt.oa.model.Student', '11', 'PC');
INSERT INTO `_activities` VALUES ('452', 'ObjectCreate', '0', '系统自动--日志', '2018-05-25 12:04:37', '0', '系统自动--日志', '2018-05-25 12:04:37', 'wq2000 创建学员咨询<wq2000(丁虹)> : <test008(13213124514)>;一次回访：null;二次回访：null;三次回访：null;备注：null;锁定时间：2018-05-25 12:04:37', 'com.bdqnsxt.oa.model.StudentConsult', '8', 'PC');
INSERT INTO `_activities` VALUES ('453', 'ObjectCreate', '0', '系统自动--日志', '2018-05-25 12:06:46', '0', '系统自动--日志', '2018-05-25 12:06:46', 'wq2001 创建学生李磊', 'com.bdqnsxt.oa.model.Student', '12', 'PC');
INSERT INTO `_activities` VALUES ('454', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-25 12:08:25', '0', '系统自动--日志', '2018-05-25 12:08:25', 'wq2000 修改学员咨询<丁虹(null)> : <test007(null)>;一次回访：1;二次回访：2;三次回访：3;备注：4;锁定时间：2018-05-25 12:08:25;面试时间：2018-05-25 16:03:01', 'com.bdqnsxt.oa.model.StudentConsult', '5', 'PC');
INSERT INTO `_activities` VALUES ('455', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 10:51:20', '0', '系统自动--日志', '2018-05-28 10:51:20', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('456', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 10:53:37', '0', '系统自动--日志', '2018-05-28 10:53:37', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('457', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 10:55:24', '0', '系统自动--日志', '2018-05-28 10:55:24', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('458', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:01:31', '0', '系统自动--日志', '2018-05-28 11:01:31', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('459', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:05:37', '0', '系统自动--日志', '2018-05-28 11:05:37', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('460', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:08:31', '0', '系统自动--日志', '2018-05-28 11:08:31', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('461', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:10:07', '0', '系统自动--日志', '2018-05-28 11:10:07', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('462', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:16:40', '0', '系统自动--日志', '2018-05-28 11:16:40', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('463', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:18:13', '0', '系统自动--日志', '2018-05-28 11:18:13', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('464', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:25:06', '0', '系统自动--日志', '2018-05-28 11:25:06', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('465', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:25:12', '0', '系统自动--日志', '2018-05-28 11:25:12', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('466', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:25:20', '0', '系统自动--日志', '2018-05-28 11:25:20', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('467', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:25:42', '0', '系统自动--日志', '2018-05-28 11:25:42', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('468', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:25:52', '0', '系统自动--日志', '2018-05-28 11:25:52', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');
INSERT INTO `_activities` VALUES ('469', 'ObjectUpdate', '0', '系统自动--日志', '2018-05-28 11:26:29', '0', '系统自动--日志', '2018-05-28 11:26:29', 'admin009 修改学生李磊', 'com.bdqnsxt.oa.model.Student', '2', 'PC');

-- ----------------------------
-- Table structure for `_clazz`
-- ----------------------------
DROP TABLE IF EXISTS `_clazz`;
CREATE TABLE `_clazz` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�༶��Ϣ��',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `clname` varchar(255) NOT NULL,
  `orientation` varchar(255) DEFAULT NULL,
  `schoolId` bigint(20) NOT NULL DEFAULT '0',
  `startDate` date NOT NULL,
  `endDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `lecturerId` bigint(20) DEFAULT '0',
  `classLeaderId` bigint(20) DEFAULT '0' COMMENT '班主任',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _clazz
-- ----------------------------
INSERT INTO `_clazz` VALUES ('00000000000000000001', 'wq(系统管理员)', '2018-05-02 14:30:27', 'admin009', '2018-05-23 15:43:56', '1', '18', '济南校区01期', 'JAVA工程师', '1', '2018-05-03', '2018-05-31', '开班', '2', '19');
INSERT INTO `_clazz` VALUES ('00000000000000000003', 'wq（admin）', '2018-05-03 17:07:17', 'wq（admin）', '2018-05-09 14:00:46', '1', '1', '河北校区01期~~', 'UI设计', '2', '2018-05-03', '2018-05-25', '开班', '6', '0');
INSERT INTO `_clazz` VALUES ('00000000000000000005', 'wq（admin）', '2018-05-04 10:26:58', 'wq（admin）', '2018-05-04 10:26:58', '1', '1', '济南校区03期', 'JAVA工程师', '1', '2018-05-04', '2018-05-31', '未开班', '2', '0');
INSERT INTO `_clazz` VALUES ('00000000000000000006', 'wq（admin）', '2018-05-04 11:28:31', 'wq（admin）', '2018-05-07 12:12:53', '1', '1', '山东校区05期', 'JAVA工程师', '1', '2018-05-04', '2018-05-31', '开班', '2', null);
INSERT INTO `_clazz` VALUES ('00000000000000000007', 'admin009', '2018-05-15 10:18:16', 'admin009', '2018-05-15 10:18:16', '18', '18', '济南校区06期', 'JAVA工程师', '1', '2018-05-15', '2018-05-24', '未开班', '2', null);

-- ----------------------------
-- Table structure for `_clazz_tutor`
-- ----------------------------
DROP TABLE IF EXISTS `_clazz_tutor`;
CREATE TABLE `_clazz_tutor` (
  `clazzId` bigint(20) NOT NULL,
  `tutorId` bigint(20) NOT NULL,
  PRIMARY KEY (`clazzId`,`tutorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _clazz_tutor
-- ----------------------------
INSERT INTO `_clazz_tutor` VALUES ('6', '3');
INSERT INTO `_clazz_tutor` VALUES ('6', '4');
INSERT INTO `_clazz_tutor` VALUES ('7', '3');
INSERT INTO `_clazz_tutor` VALUES ('7', '4');
INSERT INTO `_clazz_tutor` VALUES ('8', '3');
INSERT INTO `_clazz_tutor` VALUES ('8', '4');

-- ----------------------------
-- Table structure for `_department`
-- ----------------------------
DROP TABLE IF EXISTS `_department`;
CREATE TABLE `_department` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `dtname` varchar(255) DEFAULT NULL,
  `description` text,
  `schoolId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _department
-- ----------------------------
INSERT INTO `_department` VALUES ('00000000000000001000', 'wq（admin）', '2018-05-08 17:28:23', 'admin009', '2018-05-16 12:10:33', '1', '18', '咨询部', '咨询 ，客服~~~~!!!', '1');
INSERT INTO `_department` VALUES ('00000000000000001001', 'wq（admin）', '2018-05-08 17:31:28', 'wq（admin）', '2018-05-08 17:31:28', '1', '1', '就业部', '~~~', '1');
INSERT INTO `_department` VALUES ('00000000000000001002', 'wq（admin）', '2018-05-09 13:48:55', 'wq（admin）', '2018-05-09 13:48:55', '1', '1', '市场部', '~~~', '1');
INSERT INTO `_department` VALUES ('00000000000000001003', '00000000000000000001	wq(系统管理员)	2018-05-02 14:26:50	wq(系统管理员)	2018-05-02 14:26:55	1	1	尚学堂总部经理处	总部管理	1\r\nwq(系统管理员)', '2018-05-02 14:39:30', 'wq(系统管理员)', '2018-05-02 14:39:36', '1', '1', '教学部', '教学工作', '1');
INSERT INTO `_department` VALUES ('00000000000000001004', 'admin009', '2018-05-14 15:36:20', 'admin009', '2018-05-14 15:36:20', '18', '18', '教学部', '', '2');
INSERT INTO `_department` VALUES ('00000000000000001005', 'admin009', '2018-05-15 09:49:15', 'admin009', '2018-05-15 09:49:15', '18', '18', '行政部', '', '1');
INSERT INTO `_department` VALUES ('00000000000000001006', 'admin009', '2018-05-15 11:24:09', 'admin009', '2018-05-15 11:24:09', '18', '18', '中心管理', '', '1');
INSERT INTO `_department` VALUES ('00000000000000001007', 'admin009', '2018-05-15 11:43:04', 'admin009', '2018-05-15 11:43:04', '18', '18', '教务部', '', '1');
INSERT INTO `_department` VALUES ('00000000000000001008', 'admin009', '2018-05-15 11:45:53', 'admin009', '2018-05-15 11:45:53', '18', '18', '技术支持', '', '1');

-- ----------------------------
-- Table structure for `_doc`
-- ----------------------------
DROP TABLE IF EXISTS `_doc`;
CREATE TABLE `_doc` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `description` text,
  `location` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _doc
-- ----------------------------
INSERT INTO `_doc` VALUES ('00000000000000000168', 'admin009', '2018-05-18 10:05:14', 'admin009', '2018-05-18 10:05:14', '18', '18', '附件2-1：付费网络推广月度总结计划（竞价专员）20131120.ppt', '网络推广计划', '附件2-1：付费网络推广月度总结计划（竞价专员）20131120311534894780774973.ppt');
INSERT INTO `_doc` VALUES ('00000000000000000169', null, null, null, null, '0', '0', '中心校长岗位附件列表.xlsx', '中心校长岗位', '中心校长岗位附件列表6805867718639977677.xlsx');
INSERT INTO `_doc` VALUES ('00000000000000000176', 'admin009', '2018-05-18 16:20:23', 'admin009', '2018-05-18 16:20:23', '18', '18', '竞价专员岗位附件列表.xlsx', '', '竞价专员岗位附件列表3545491118296316411.xlsx');
INSERT INTO `_doc` VALUES ('00000000000000000177', 'admin009', '2018-05-19 08:59:25', 'admin009', '2018-05-19 08:59:25', '18', '18', '场地考察记录.doc', '', '场地考察记录4371002388695862453.doc');
INSERT INTO `_doc` VALUES ('00000000000000000178', 'admin009', '2018-05-23 15:46:56', 'admin009', '2018-05-23 15:46:56', '18', '18', '附件1-1：中心年度利润总结.xls', '', '附件1-1：中心年度利润总结7758535673339372251.xls');

-- ----------------------------
-- Table structure for `_doc_cat`
-- ----------------------------
DROP TABLE IF EXISTS `_doc_cat`;
CREATE TABLE `_doc_cat` (
  `docId` bigint(20) NOT NULL DEFAULT '0',
  `catId` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`docId`,`catId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _doc_cat
-- ----------------------------
INSERT INTO `_doc_cat` VALUES ('168', '75');
INSERT INTO `_doc_cat` VALUES ('168', '123');
INSERT INTO `_doc_cat` VALUES ('169', '5');
INSERT INTO `_doc_cat` VALUES ('176', '74');
INSERT INTO `_doc_cat` VALUES ('177', '79');
INSERT INTO `_doc_cat` VALUES ('177', '127');
INSERT INTO `_doc_cat` VALUES ('178', '29');

-- ----------------------------
-- Table structure for `_doccat`
-- ----------------------------
DROP TABLE IF EXISTS `_doccat`;
CREATE TABLE `_doccat` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `parentId` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _doccat
-- ----------------------------
INSERT INTO `_doccat` VALUES ('00000000000000000005', null, null, null, null, '0', '0', '中心校长', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000006', null, null, null, null, '0', '0', '网络主管', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000007', null, null, null, null, '0', '0', '竞价专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000008', null, null, null, null, '0', '0', '在线咨询师', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000009', null, null, null, null, '0', '0', '市场活动主管', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000010', null, null, null, null, '0', '0', '市场活动专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000011', null, null, null, null, '0', '0', '电话销售专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000012', null, null, null, null, '0', '0', '咨询主管', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000013', null, null, null, null, '0', '0', '咨询师', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000014', null, null, null, null, '0', '0', '咨询助理', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000015', null, null, null, null, '0', '0', '学术部经理', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000016', null, null, null, null, '0', '0', '教员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000017', null, null, null, null, '0', '0', '技术顾问', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000018', null, null, null, null, '0', '0', '技术支持', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000019', null, null, null, null, '0', '0', '教质部经理', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000020', null, null, null, null, '0', '0', '班主任', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000021', null, null, null, null, '0', '0', '辅导员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000022', null, null, null, null, '0', '0', '教务', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000023', null, null, null, null, '0', '0', '就业部经理', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000024', null, null, null, null, '0', '0', '就业专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000025', null, null, null, null, '0', '0', '人事专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000026', null, null, null, null, '0', '0', '行政专员', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000027', null, null, null, null, '0', '0', '出纳', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000028', null, null, null, null, '0', '0', '会计', '0');
INSERT INTO `_doccat` VALUES ('00000000000000000029', null, null, null, null, '0', '0', '中心校长岗位附件', '5');
INSERT INTO `_doccat` VALUES ('00000000000000000031', 'admin009', '2018-05-16 13:36:56', 'admin009', '2018-05-16 13:36:56', '18', '18', '中心考核体系（参考）', '5');
INSERT INTO `_doccat` VALUES ('00000000000000000032', 'admin009', '2018-05-16 13:50:12', 'admin009', '2018-05-16 13:50:12', '18', '18', '指标图相关附件', '5');
INSERT INTO `_doccat` VALUES ('00000000000000000033', 'admin009', '2018-05-16 13:50:36', 'admin009', '2018-05-16 13:50:36', '18', '18', '网络主管岗位附件', '6');
INSERT INTO `_doccat` VALUES ('00000000000000000034', 'admin009', '2018-05-16 13:50:50', 'admin009', '2018-05-16 13:52:54', '18', '18', '网络推广指标图相关附件', '6');
INSERT INTO `_doccat` VALUES ('00000000000000000035', 'admin009', '2018-05-16 13:51:13', 'admin009', '2018-05-16 13:51:13', '18', '18', '竞价专员岗位附件', '7');
INSERT INTO `_doccat` VALUES ('00000000000000000036', 'admin009', '2018-05-16 13:51:31', 'admin009', '2018-05-16 13:51:31', '18', '18', '在线咨询师岗位附件', '8');
INSERT INTO `_doccat` VALUES ('00000000000000000037', 'admin009', '2018-05-16 13:51:52', 'admin009', '2018-05-16 13:51:52', '18', '18', '市场活动主管岗位附件', '9');
INSERT INTO `_doccat` VALUES ('00000000000000000038', 'admin009', '2018-05-16 13:52:16', 'admin009', '2018-05-16 13:53:03', '18', '18', '市场活动指标图相关附件', '9');
INSERT INTO `_doccat` VALUES ('00000000000000000039', 'admin009', '2018-05-16 13:52:45', 'admin009', '2018-05-16 13:52:45', '18', '18', '市场活动专员岗位附件', '10');
INSERT INTO `_doccat` VALUES ('00000000000000000040', 'admin009', '2018-05-16 13:53:24', 'admin009', '2018-05-16 13:53:24', '18', '18', '电话销售专员岗位附件', '11');
INSERT INTO `_doccat` VALUES ('00000000000000000041', 'admin009', '2018-05-16 13:53:43', 'admin009', '2018-05-16 13:53:43', '18', '18', '咨询主管岗位附件', '12');
INSERT INTO `_doccat` VALUES ('00000000000000000042', 'admin009', '2018-05-16 13:53:59', 'admin009', '2018-05-16 13:53:59', '18', '18', '咨询业务指标图相关附件', '12');
INSERT INTO `_doccat` VALUES ('00000000000000000043', 'admin009', '2018-05-16 13:54:14', 'admin009', '2018-05-16 13:54:14', '18', '18', '咨询师岗位附件', '13');
INSERT INTO `_doccat` VALUES ('00000000000000000044', 'admin009', '2018-05-16 13:54:50', 'admin009', '2018-05-16 13:54:50', '18', '18', '咨询助理岗位附件', '14');
INSERT INTO `_doccat` VALUES ('00000000000000000045', 'admin009', '2018-05-16 13:55:06', 'admin009', '2018-05-16 13:55:06', '18', '18', '学术部经理岗位附件', '15');
INSERT INTO `_doccat` VALUES ('00000000000000000046', 'admin009', '2018-05-16 13:55:23', 'admin009', '2018-05-16 13:55:23', '18', '18', '学士后教学业务指标图相关附件', '15');
INSERT INTO `_doccat` VALUES ('00000000000000000047', 'admin009', '2018-05-16 13:55:40', 'admin009', '2018-05-16 13:55:40', '18', '18', '教学业务指标图相关附件', '15');
INSERT INTO `_doccat` VALUES ('00000000000000000048', 'admin009', '2018-05-16 13:55:56', 'admin009', '2018-05-16 13:55:56', '18', '18', '教员岗位附件', '16');
INSERT INTO `_doccat` VALUES ('00000000000000000049', 'admin009', '2018-05-16 13:56:11', 'admin009', '2018-05-16 13:56:11', '18', '18', '技术顾问岗位附件', '17');
INSERT INTO `_doccat` VALUES ('00000000000000000050', 'admin009', '2018-05-16 13:56:27', 'admin009', '2018-05-16 13:56:27', '18', '18', '技术支持岗位附件', '18');
INSERT INTO `_doccat` VALUES ('00000000000000000051', 'admin009', '2018-05-16 13:56:44', 'admin009', '2018-05-16 13:56:44', '18', '18', '教质部经理岗位附件', '19');
INSERT INTO `_doccat` VALUES ('00000000000000000052', 'admin009', '2018-05-16 13:56:59', 'admin009', '2018-05-16 13:57:05', '18', '18', '学士后教质业务指标图相关附件', '19');
INSERT INTO `_doccat` VALUES ('00000000000000000053', 'admin009', '2018-05-16 13:57:20', 'admin009', '2018-05-16 13:57:20', '18', '18', '教质业务指标图相关附件', '19');
INSERT INTO `_doccat` VALUES ('00000000000000000054', 'admin009', '2018-05-16 13:57:37', 'admin009', '2018-05-16 13:57:37', '18', '18', '班主任岗位附件', '20');
INSERT INTO `_doccat` VALUES ('00000000000000000055', 'admin009', '2018-05-16 13:57:50', 'admin009', '2018-05-16 13:57:50', '18', '18', '辅导员岗位附件', '21');
INSERT INTO `_doccat` VALUES ('00000000000000000056', 'admin009', '2018-05-16 13:58:05', 'admin009', '2018-05-16 13:58:05', '18', '18', '教务岗位附件', '22');
INSERT INTO `_doccat` VALUES ('00000000000000000057', 'admin009', '2018-05-16 13:58:24', 'admin009', '2018-05-16 13:58:24', '18', '18', '就业部经理岗位附件', '23');
INSERT INTO `_doccat` VALUES ('00000000000000000058', 'admin009', '2018-05-16 13:58:39', 'admin009', '2018-05-16 13:58:39', '18', '18', '就业业务指标图相关附件', '23');
INSERT INTO `_doccat` VALUES ('00000000000000000059', 'admin009', '2018-05-16 13:58:54', 'admin009', '2018-05-16 13:58:54', '18', '18', '就业专员岗位附件', '24');
INSERT INTO `_doccat` VALUES ('00000000000000000060', 'admin009', '2018-05-16 13:59:13', 'admin009', '2018-05-16 13:59:13', '18', '18', '人事专员岗位附件', '25');
INSERT INTO `_doccat` VALUES ('00000000000000000061', 'admin009', '2018-05-16 13:59:54', 'admin009', '2018-05-16 13:59:54', '18', '18', '行政专员岗位附件', '26');
INSERT INTO `_doccat` VALUES ('00000000000000000062', 'admin009', '2018-05-16 14:00:08', 'admin009', '2018-05-16 14:00:08', '18', '18', '出纳岗位附件', '27');
INSERT INTO `_doccat` VALUES ('00000000000000000063', 'admin009', '2018-05-16 14:00:21', 'admin009', '2018-05-16 14:00:21', '18', '18', '会计岗位附件', '28');
INSERT INTO `_doccat` VALUES ('00000000000000000064', 'admin009', '2018-05-16 14:01:14', 'admin009', '2018-05-16 14:01:14', '18', '18', '01网络推广指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000065', 'admin009', '2018-05-16 14:01:26', 'admin009', '2018-05-16 14:01:26', '18', '18', '02市场活动指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000066', 'admin009', '2018-05-16 14:01:40', 'admin009', '2018-05-16 14:01:40', '18', '18', '03咨询业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000067', 'admin009', '2018-05-16 14:01:51', 'admin009', '2018-05-16 14:01:51', '18', '18', '04教学业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000068', 'admin009', '2018-05-16 14:02:02', 'admin009', '2018-05-16 14:02:02', '18', '18', '05教质业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000069', 'admin009', '2018-05-16 14:02:24', 'admin009', '2018-05-16 14:02:24', '18', '18', '06就业业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000070', 'admin009', '2018-05-16 14:02:35', 'admin009', '2018-05-16 14:02:35', '18', '18', '07学士后教学业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000071', 'admin009', '2018-05-16 14:03:03', 'admin009', '2018-05-16 14:03:03', '18', '18', '08学士后教质业务指标图相关附件', '32');
INSERT INTO `_doccat` VALUES ('00000000000000000072', 'admin009', '2018-05-16 14:04:09', 'admin009', '2018-05-16 14:04:09', '18', '18', '基础数据表', '64');
INSERT INTO `_doccat` VALUES ('00000000000000000073', 'admin009', '2018-05-16 14:04:24', 'admin009', '2018-05-16 14:04:24', '18', '18', '分析数据表及PPT', '64');
INSERT INTO `_doccat` VALUES ('00000000000000000074', 'admin009', '2018-05-16 14:04:41', 'admin009', '2018-05-16 14:04:41', '18', '18', '竞价专员', '72');
INSERT INTO `_doccat` VALUES ('00000000000000000075', 'admin009', '2018-05-16 14:05:04', 'admin009', '2018-05-16 14:05:24', '18', '18', '网络主管', '73');
INSERT INTO `_doccat` VALUES ('00000000000000000076', 'admin009', '2018-05-16 14:05:44', 'admin009', '2018-05-16 14:05:44', '18', '18', '原始记录单', '65');
INSERT INTO `_doccat` VALUES ('00000000000000000077', 'admin009', '2018-05-16 14:05:57', 'admin009', '2018-05-16 14:05:57', '18', '18', '基础数据表', '65');
INSERT INTO `_doccat` VALUES ('00000000000000000078', 'admin009', '2018-05-16 14:06:09', 'admin009', '2018-05-16 14:06:09', '18', '18', '分析数据表及PPT', '65');
INSERT INTO `_doccat` VALUES ('00000000000000000079', 'admin009', '2018-05-16 14:06:23', 'admin009', '2018-05-16 14:06:23', '18', '18', '市场活动专员', '76');
INSERT INTO `_doccat` VALUES ('00000000000000000080', 'admin009', '2018-05-16 14:07:27', 'admin009', '2018-05-16 14:07:27', '18', '18', '市场活动专员', '77');
INSERT INTO `_doccat` VALUES ('00000000000000000081', 'admin009', '2018-05-16 14:07:41', 'admin009', '2018-05-16 14:07:41', '18', '18', '市场活动主管', '77');
INSERT INTO `_doccat` VALUES ('00000000000000000082', 'admin009', '2018-05-16 14:07:53', 'admin009', '2018-05-16 14:07:53', '18', '18', '电话销售专员', '77');
INSERT INTO `_doccat` VALUES ('00000000000000000083', 'admin009', '2018-05-16 14:08:23', 'admin009', '2018-05-16 14:08:23', '18', '18', '市场活动专员', '78');
INSERT INTO `_doccat` VALUES ('00000000000000000084', 'admin009', '2018-05-16 14:08:37', 'admin009', '2018-05-16 14:08:37', '18', '18', '市场活动主管', '78');
INSERT INTO `_doccat` VALUES ('00000000000000000085', 'admin009', '2018-05-16 14:08:50', 'admin009', '2018-05-16 14:08:50', '18', '18', '电话销售专员', '78');
INSERT INTO `_doccat` VALUES ('00000000000000000086', 'admin009', '2018-05-16 14:09:22', 'admin009', '2018-05-16 14:09:22', '18', '18', '原始记录单', '66');
INSERT INTO `_doccat` VALUES ('00000000000000000087', 'admin009', '2018-05-16 14:11:53', 'admin009', '2018-05-16 14:11:53', '18', '18', '基础数据表', '66');
INSERT INTO `_doccat` VALUES ('00000000000000000088', 'admin009', '2018-05-16 14:13:00', 'admin009', '2018-05-16 14:13:00', '18', '18', '分析数据表及PPT', '66');
INSERT INTO `_doccat` VALUES ('00000000000000000094', 'admin009', '2018-05-16 15:53:35', 'admin009', '2018-05-16 15:53:35', '18', '18', '咨询师', '86');
INSERT INTO `_doccat` VALUES ('00000000000000000095', 'admin009', '2018-05-16 15:55:51', 'admin009', '2018-05-16 15:55:51', '18', '18', '咨询助理', '87');
INSERT INTO `_doccat` VALUES ('00000000000000000096', 'admin009', '2018-05-16 15:56:07', 'admin009', '2018-05-16 15:56:07', '18', '18', '咨询主管', '88');
INSERT INTO `_doccat` VALUES ('00000000000000000097', 'admin009', '2018-05-16 15:56:28', 'admin009', '2018-05-16 15:56:28', '18', '18', '原始记录单', '67');
INSERT INTO `_doccat` VALUES ('00000000000000000098', 'admin009', '2018-05-16 15:56:38', 'admin009', '2018-05-16 15:56:38', '18', '18', '分析数据表及PPT', '67');
INSERT INTO `_doccat` VALUES ('00000000000000000099', 'admin009', '2018-05-16 15:56:51', 'admin009', '2018-05-16 15:56:51', '18', '18', '学术部经理', '97');
INSERT INTO `_doccat` VALUES ('00000000000000000100', 'admin009', '2018-05-16 15:57:15', 'admin009', '2018-05-16 15:57:15', '18', '18', '教员', '97');
INSERT INTO `_doccat` VALUES ('00000000000000000101', 'admin009', '2018-05-16 15:57:36', 'admin009', '2018-05-16 15:57:36', '18', '18', '学术部经理', '98');
INSERT INTO `_doccat` VALUES ('00000000000000000102', 'admin009', '2018-05-16 15:57:53', 'admin009', '2018-05-16 15:57:53', '18', '18', '原始记录单', '68');
INSERT INTO `_doccat` VALUES ('00000000000000000103', 'admin009', '2018-05-16 15:58:03', 'admin009', '2018-05-16 15:58:03', '18', '18', '基础数据表', '68');
INSERT INTO `_doccat` VALUES ('00000000000000000104', 'admin009', '2018-05-16 15:58:14', 'admin009', '2018-05-16 15:58:14', '18', '18', '分析数据表及PPT', '68');
INSERT INTO `_doccat` VALUES ('00000000000000000105', 'admin009', '2018-05-16 15:58:36', 'admin009', '2018-05-16 15:58:36', '18', '18', '教质部经理', '102');
INSERT INTO `_doccat` VALUES ('00000000000000000106', 'admin009', '2018-05-16 15:58:48', 'admin009', '2018-05-16 15:58:48', '18', '18', '班主任', '102');
INSERT INTO `_doccat` VALUES ('00000000000000000107', 'admin009', '2018-05-16 15:59:07', 'admin009', '2018-05-16 15:59:07', '18', '18', '班主任', '103');
INSERT INTO `_doccat` VALUES ('00000000000000000108', 'admin009', '2018-05-16 15:59:18', 'admin009', '2018-05-16 15:59:18', '18', '18', '教质部经理', '104');
INSERT INTO `_doccat` VALUES ('00000000000000000109', 'admin009', '2018-05-16 15:59:36', 'admin009', '2018-05-16 15:59:36', '18', '18', '原始记录单', '69');
INSERT INTO `_doccat` VALUES ('00000000000000000110', 'admin009', '2018-05-16 15:59:48', 'admin009', '2018-05-16 15:59:48', '18', '18', '基础数据表', '69');
INSERT INTO `_doccat` VALUES ('00000000000000000111', 'admin009', '2018-05-16 15:59:57', 'admin009', '2018-05-16 15:59:57', '18', '18', '分析数据表及PPT', '69');
INSERT INTO `_doccat` VALUES ('00000000000000000112', 'admin009', '2018-05-16 16:00:08', 'admin009', '2018-05-16 16:00:08', '18', '18', '就业专员', '109');
INSERT INTO `_doccat` VALUES ('00000000000000000113', 'admin009', '2018-05-16 16:00:16', 'admin009', '2018-05-16 16:00:16', '18', '18', '就业部经理', '109');
INSERT INTO `_doccat` VALUES ('00000000000000000114', 'admin009', '2018-05-16 16:00:31', 'admin009', '2018-05-16 16:00:31', '18', '18', '就业专员', '110');
INSERT INTO `_doccat` VALUES ('00000000000000000115', 'admin009', '2018-05-16 16:00:40', 'admin009', '2018-05-16 16:00:40', '18', '18', '就业部经理', '110');
INSERT INTO `_doccat` VALUES ('00000000000000000116', 'admin009', '2018-05-16 16:00:54', 'admin009', '2018-05-16 16:00:54', '18', '18', '就业专员', '111');
INSERT INTO `_doccat` VALUES ('00000000000000000117', 'admin009', '2018-05-16 16:01:03', 'admin009', '2018-05-16 16:01:03', '18', '18', '就业部经理', '111');
INSERT INTO `_doccat` VALUES ('00000000000000000118', 'admin009', '2018-05-16 16:01:23', 'admin009', '2018-05-16 16:01:23', '18', '18', '基础数据表-技术顾问', '70');
INSERT INTO `_doccat` VALUES ('00000000000000000119', 'admin009', '2018-05-16 16:02:03', 'admin009', '2018-05-16 16:02:03', '18', '18', '基础数据表-辅导员', '71');
INSERT INTO `_doccat` VALUES ('00000000000000000120', 'admin009', '2018-05-16 16:03:50', 'admin009', '2018-05-16 16:03:50', '18', '18', '基础数据表', '34');
INSERT INTO `_doccat` VALUES ('00000000000000000121', 'admin009', '2018-05-16 16:04:19', 'admin009', '2018-05-16 16:04:19', '18', '18', '竞价专员', '120');
INSERT INTO `_doccat` VALUES ('00000000000000000122', 'admin009', '2018-05-16 16:04:29', 'admin009', '2018-05-16 16:04:29', '18', '18', '分析数据表及PPT', '34');
INSERT INTO `_doccat` VALUES ('00000000000000000123', 'admin009', '2018-05-16 16:04:42', 'admin009', '2018-05-16 16:04:42', '18', '18', '网络主管', '122');
INSERT INTO `_doccat` VALUES ('00000000000000000124', 'admin009', '2018-05-16 16:06:12', 'admin009', '2018-05-16 16:06:12', '18', '18', '原始记录单', '38');
INSERT INTO `_doccat` VALUES ('00000000000000000125', 'admin009', '2018-05-16 16:06:22', 'admin009', '2018-05-16 16:06:22', '18', '18', '基础数据表', '38');
INSERT INTO `_doccat` VALUES ('00000000000000000126', 'admin009', '2018-05-16 16:06:30', 'admin009', '2018-05-16 16:06:30', '18', '18', '分析数据表及PPT', '38');
INSERT INTO `_doccat` VALUES ('00000000000000000127', 'admin009', '2018-05-16 16:06:51', 'admin009', '2018-05-16 16:06:51', '18', '18', '市场活动专员', '124');
INSERT INTO `_doccat` VALUES ('00000000000000000128', 'admin009', '2018-05-16 16:07:43', 'admin009', '2018-05-16 16:07:43', '18', '18', '市场活动专员', '125');
INSERT INTO `_doccat` VALUES ('00000000000000000129', 'admin009', '2018-05-16 16:07:52', 'admin009', '2018-05-16 16:07:52', '18', '18', '市场活动主管', '125');
INSERT INTO `_doccat` VALUES ('00000000000000000130', 'admin009', '2018-05-16 16:08:00', 'admin009', '2018-05-16 16:08:00', '18', '18', '电话销售专员', '125');
INSERT INTO `_doccat` VALUES ('00000000000000000131', 'admin009', '2018-05-16 16:08:13', 'admin009', '2018-05-16 16:08:13', '18', '18', '市场活动专员', '126');
INSERT INTO `_doccat` VALUES ('00000000000000000132', 'admin009', '2018-05-16 16:08:24', 'admin009', '2018-05-16 16:08:24', '18', '18', '市场活动主管', '126');
INSERT INTO `_doccat` VALUES ('00000000000000000133', 'admin009', '2018-05-16 16:08:44', 'admin009', '2018-05-16 16:08:44', '18', '18', '电话销售专员', '126');
INSERT INTO `_doccat` VALUES ('00000000000000000134', 'admin009', '2018-05-16 16:09:49', 'admin009', '2018-05-16 16:09:49', '18', '18', '原始记录单', '42');
INSERT INTO `_doccat` VALUES ('00000000000000000135', 'admin009', '2018-05-16 16:09:58', 'admin009', '2018-05-16 16:09:58', '18', '18', '基础数据表', '42');
INSERT INTO `_doccat` VALUES ('00000000000000000136', 'admin009', '2018-05-16 16:10:08', 'admin009', '2018-05-16 16:10:08', '18', '18', '分析数据表及PPT', '42');
INSERT INTO `_doccat` VALUES ('00000000000000000137', 'admin009', '2018-05-16 16:10:44', 'admin009', '2018-05-16 16:10:44', '18', '18', '咨询师', '134');
INSERT INTO `_doccat` VALUES ('00000000000000000138', 'admin009', '2018-05-16 16:11:02', 'admin009', '2018-05-16 16:11:02', '18', '18', '咨询助理', '135');
INSERT INTO `_doccat` VALUES ('00000000000000000139', 'admin009', '2018-05-16 16:11:21', 'admin009', '2018-05-16 16:11:21', '18', '18', '咨询主管', '136');
INSERT INTO `_doccat` VALUES ('00000000000000000140', 'admin009', '2018-05-16 16:12:31', 'admin009', '2018-05-16 16:12:31', '18', '18', '基础数据表-技术顾问', '46');
INSERT INTO `_doccat` VALUES ('00000000000000000141', 'admin009', '2018-05-16 16:12:48', 'admin009', '2018-05-16 16:12:48', '18', '18', '原始记录单', '47');
INSERT INTO `_doccat` VALUES ('00000000000000000142', 'admin009', '2018-05-16 16:13:00', 'admin009', '2018-05-16 16:13:00', '18', '18', '分析数据表及PPT', '47');
INSERT INTO `_doccat` VALUES ('00000000000000000143', 'admin009', '2018-05-16 16:13:10', 'admin009', '2018-05-16 16:13:10', '18', '18', '学术部经理', '141');
INSERT INTO `_doccat` VALUES ('00000000000000000144', 'admin009', '2018-05-16 16:13:26', 'admin009', '2018-05-16 16:13:26', '18', '18', '教员', '141');
INSERT INTO `_doccat` VALUES ('00000000000000000145', 'admin009', '2018-05-16 16:13:42', 'admin009', '2018-05-16 16:13:42', '18', '18', '学术部经理', '142');
INSERT INTO `_doccat` VALUES ('00000000000000000147', 'admin009', '2018-05-16 16:15:23', 'admin009', '2018-05-16 16:15:23', '18', '18', '基础数据表-辅导员', '52');
INSERT INTO `_doccat` VALUES ('00000000000000000148', 'admin009', '2018-05-16 16:15:38', 'admin009', '2018-05-16 16:15:38', '18', '18', '原始记录单', '53');
INSERT INTO `_doccat` VALUES ('00000000000000000149', 'admin009', '2018-05-16 16:15:48', 'admin009', '2018-05-16 16:15:48', '18', '18', '教质部经理', '148');
INSERT INTO `_doccat` VALUES ('00000000000000000150', 'admin009', '2018-05-16 16:15:57', 'admin009', '2018-05-16 16:15:57', '18', '18', '班主任', '148');
INSERT INTO `_doccat` VALUES ('00000000000000000151', 'admin009', '2018-05-16 16:16:14', 'admin009', '2018-05-16 16:16:14', '18', '18', '基础数据表', '53');
INSERT INTO `_doccat` VALUES ('00000000000000000152', 'admin009', '2018-05-16 16:16:24', 'admin009', '2018-05-16 16:16:24', '18', '18', '班主任', '151');
INSERT INTO `_doccat` VALUES ('00000000000000000153', 'admin009', '2018-05-16 16:16:37', 'admin009', '2018-05-16 16:16:37', '18', '18', '分析数据表及PPT', '53');
INSERT INTO `_doccat` VALUES ('00000000000000000154', 'admin009', '2018-05-16 16:16:49', 'admin009', '2018-05-16 16:16:49', '18', '18', '教质部经理', '153');
INSERT INTO `_doccat` VALUES ('00000000000000000155', 'admin009', '2018-05-16 16:17:36', 'admin009', '2018-05-16 16:17:36', '18', '18', '原始记录单', '58');
INSERT INTO `_doccat` VALUES ('00000000000000000156', 'admin009', '2018-05-16 16:17:47', 'admin009', '2018-05-16 16:17:47', '18', '18', '基础数据表', '58');
INSERT INTO `_doccat` VALUES ('00000000000000000157', 'admin009', '2018-05-16 16:17:55', 'admin009', '2018-05-16 16:17:55', '18', '18', '分析数据表及PPT', '58');
INSERT INTO `_doccat` VALUES ('00000000000000000158', 'admin009', '2018-05-16 16:18:07', 'admin009', '2018-05-16 16:18:07', '18', '18', '就业专员', '155');
INSERT INTO `_doccat` VALUES ('00000000000000000159', 'admin009', '2018-05-16 16:18:17', 'admin009', '2018-05-16 16:18:17', '18', '18', '就业部经理', '155');
INSERT INTO `_doccat` VALUES ('00000000000000000160', 'admin009', '2018-05-16 16:18:29', 'admin009', '2018-05-16 16:18:29', '18', '18', '就业专员', '156');
INSERT INTO `_doccat` VALUES ('00000000000000000161', 'admin009', '2018-05-16 16:18:38', 'admin009', '2018-05-16 16:18:38', '18', '18', '就业部经理', '156');
INSERT INTO `_doccat` VALUES ('00000000000000000162', 'admin009', '2018-05-16 16:18:50', 'admin009', '2018-05-16 16:18:50', '18', '18', '就业专员', '157');
INSERT INTO `_doccat` VALUES ('00000000000000000163', 'admin009', '2018-05-16 16:18:59', 'admin009', '2018-05-16 16:18:59', '18', '18', '就业部经理', '157');
INSERT INTO `_doccat` VALUES ('00000000000000000166', 'admin009', '2018-05-21 12:29:28', 'admin009', '2018-05-21 12:29:28', '18', '18', 'test', '5');

-- ----------------------------
-- Table structure for `_resource`
-- ----------------------------
DROP TABLE IF EXISTS `_resource`;
CREATE TABLE `_resource` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `type` varchar(255) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `itemId` varchar(255) DEFAULT NULL,
  `parentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _resource
-- ----------------------------
INSERT INTO `_resource` VALUES ('00000000000000000178', null, null, null, null, '0', '0', 'buttons', '新增', 'createdocumentcate', '模板分类创建按钮', 'createdocumentcate', 'documentcatetreeitemid');
INSERT INTO `_resource` VALUES ('00000000000000000179', null, null, null, null, '0', '0', 'buttons', '删除', 'deletedocumentcate', '模板分类删除按钮', 'deletedocumentcate', 'documentcatetreeitemid');
INSERT INTO `_resource` VALUES ('00000000000000000180', null, null, null, null, '0', '0', 'buttons', '增加', 'createdocumentitem', '模板创建按钮', 'createdocumentitem', 'documentgridid');
INSERT INTO `_resource` VALUES ('00000000000000000181', null, null, null, null, '0', '0', 'buttons', '删除', 'deletedocumentitem', '模板删除按钮', 'deletedocumentitem', 'documentgridid');
INSERT INTO `_resource` VALUES ('00000000000000000182', null, null, null, null, '0', '0', 'button', '锁定', 'lockstudent', '学员锁定按钮', 'lockstudent', 'studentgriddockitemId');

-- ----------------------------
-- Table structure for `_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `_role_menu`;
CREATE TABLE `_role_menu` (
  `roleId` bigint(20) DEFAULT NULL,
  `menuId` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _role_menu
-- ----------------------------
INSERT INTO `_role_menu` VALUES ('2010', 'edu_manager', '87');
INSERT INTO `_role_menu` VALUES ('2010', 'clazz_manager', '88');
INSERT INTO `_role_menu` VALUES ('2010', 'stu_manager', '89');
INSERT INTO `_role_menu` VALUES ('2010', 'menu_codeview', '90');
INSERT INTO `_role_menu` VALUES ('2010', 'doc_manager', '91');
INSERT INTO `_role_menu` VALUES ('2010', 'regulation_manager', '92');
INSERT INTO `_role_menu` VALUES ('2010', 'regulation_view', '93');
INSERT INTO `_role_menu` VALUES ('2010', 'template_manager', '94');
INSERT INTO `_role_menu` VALUES ('2010', 'template_download', '95');
INSERT INTO `_role_menu` VALUES ('2012', 'edu_manager', '96');
INSERT INTO `_role_menu` VALUES ('2012', 'clazz_manager', '97');
INSERT INTO `_role_menu` VALUES ('2027', 'doc_manager', '112');
INSERT INTO `_role_menu` VALUES ('2027', 'regulation_manager', '113');
INSERT INTO `_role_menu` VALUES ('2027', 'regulation_upload', '114');
INSERT INTO `_role_menu` VALUES ('2037', 'doc_manager', '115');
INSERT INTO `_role_menu` VALUES ('2037', 'regulation_manager', '116');
INSERT INTO `_role_menu` VALUES ('2037', 'regulation_upload', '117');
INSERT INTO `_role_menu` VALUES ('2014', 'hr_manager', '118');
INSERT INTO `_role_menu` VALUES ('2014', 'user_manager', '119');
INSERT INTO `_role_menu` VALUES ('2014', 'menu_userview', '120');
INSERT INTO `_role_menu` VALUES ('2014', 'department_manager', '121');
INSERT INTO `_role_menu` VALUES ('2014', 'menu_departmentview', '122');
INSERT INTO `_role_menu` VALUES ('2014', 'edu_manager', '123');
INSERT INTO `_role_menu` VALUES ('2014', 'school_manager', '124');
INSERT INTO `_role_menu` VALUES ('2014', 'clazz_manager', '125');
INSERT INTO `_role_menu` VALUES ('2014', 'teacher_manager', '126');
INSERT INTO `_role_menu` VALUES ('2014', 'stu_manager', '127');
INSERT INTO `_role_menu` VALUES ('2014', 'stu_info_manager', '128');
INSERT INTO `_role_menu` VALUES ('2014', 'menu_stuview', '129');
INSERT INTO `_role_menu` VALUES ('2014', 'stu_score_manager', '130');
INSERT INTO `_role_menu` VALUES ('2014', 'menu_codeview', '131');
INSERT INTO `_role_menu` VALUES ('2014', 'finance_manager', '132');
INSERT INTO `_role_menu` VALUES ('2014', 'finance_school_manager', '133');
INSERT INTO `_role_menu` VALUES ('2014', 'finance_approval_manager', '134');
INSERT INTO `_role_menu` VALUES ('2014', 'consult_manager', '135');
INSERT INTO `_role_menu` VALUES ('2014', 'customer_manager', '136');
INSERT INTO `_role_menu` VALUES ('2014', 'doc_manager', '137');
INSERT INTO `_role_menu` VALUES ('2014', 'regulation_manager', '138');
INSERT INTO `_role_menu` VALUES ('2014', 'regulation_upload', '139');
INSERT INTO `_role_menu` VALUES ('2002', 'edu_manager', '140');
INSERT INTO `_role_menu` VALUES ('2002', 'clazz_manager', '141');
INSERT INTO `_role_menu` VALUES ('2002', 'stu_manager', '142');
INSERT INTO `_role_menu` VALUES ('2002', 'stu_info_manager', '143');
INSERT INTO `_role_menu` VALUES ('2002', 'menu_stuview', '144');
INSERT INTO `_role_menu` VALUES ('2002', 'menu_codeview', '145');
INSERT INTO `_role_menu` VALUES ('2002', 'doc_manager', '146');
INSERT INTO `_role_menu` VALUES ('2002', 'regulation_manager', '147');
INSERT INTO `_role_menu` VALUES ('2002', 'regulation_upload', '148');
INSERT INTO `_role_menu` VALUES ('2017', 'stu_manager', '167');
INSERT INTO `_role_menu` VALUES ('2017', 'stu_info_manager', '168');
INSERT INTO `_role_menu` VALUES ('2017', 'menu_stuview', '169');
INSERT INTO `_role_menu` VALUES ('2017', 'consult_manager', '170');
INSERT INTO `_role_menu` VALUES ('2017', 'customer_manager', '171');
INSERT INTO `_role_menu` VALUES ('2017', 'consult_trace', '172');
INSERT INTO `_role_menu` VALUES ('2017', 'doc_manager', '173');
INSERT INTO `_role_menu` VALUES ('2017', 'regulation_manager', '174');
INSERT INTO `_role_menu` VALUES ('2017', 'regulation_upload', '175');
INSERT INTO `_role_menu` VALUES ('2018', 'stu_manager', '176');
INSERT INTO `_role_menu` VALUES ('2018', 'stu_info_manager', '177');
INSERT INTO `_role_menu` VALUES ('2018', 'menu_stuview', '178');
INSERT INTO `_role_menu` VALUES ('2018', 'stu_score_manager', '179');
INSERT INTO `_role_menu` VALUES ('2018', 'menu_codeview', '180');
INSERT INTO `_role_menu` VALUES ('2018', 'consult_manager', '181');
INSERT INTO `_role_menu` VALUES ('2018', 'customer_manager', '182');
INSERT INTO `_role_menu` VALUES ('2018', 'consult_trace', '183');
INSERT INTO `_role_menu` VALUES ('2018', 'doc_manager', '184');
INSERT INTO `_role_menu` VALUES ('2018', 'regulation_manager', '185');
INSERT INTO `_role_menu` VALUES ('2018', 'regulation_upload', '186');

-- ----------------------------
-- Table structure for `_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `_role_resource`;
CREATE TABLE `_role_resource` (
  `roleId` bigint(20) NOT NULL DEFAULT '0',
  `resourceId` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleId`,`resourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _role_resource
-- ----------------------------
INSERT INTO `_role_resource` VALUES ('2014', '178');
INSERT INTO `_role_resource` VALUES ('2014', '179');
INSERT INTO `_role_resource` VALUES ('2014', '180');
INSERT INTO `_role_resource` VALUES ('2014', '181');
INSERT INTO `_role_resource` VALUES ('2016', '182');
INSERT INTO `_role_resource` VALUES ('2017', '182');
INSERT INTO `_role_resource` VALUES ('2018', '182');
INSERT INTO `_role_resource` VALUES ('2019', '182');

-- ----------------------------
-- Table structure for `_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `_role_user`;
CREATE TABLE `_role_user` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _role_user
-- ----------------------------
INSERT INTO `_role_user` VALUES ('2', '2002');
INSERT INTO `_role_user` VALUES ('5', '2002');
INSERT INTO `_role_user` VALUES ('6', '2002');
INSERT INTO `_role_user` VALUES ('10', '2002');
INSERT INTO `_role_user` VALUES ('10', '2027');
INSERT INTO `_role_user` VALUES ('10', '2034');
INSERT INTO `_role_user` VALUES ('11', '2002');
INSERT INTO `_role_user` VALUES ('12', '2017');
INSERT INTO `_role_user` VALUES ('13', '2016');
INSERT INTO `_role_user` VALUES ('13', '2018');
INSERT INTO `_role_user` VALUES ('14', '2002');
INSERT INTO `_role_user` VALUES ('16', '2014');
INSERT INTO `_role_user` VALUES ('19', '2012');
INSERT INTO `_role_user` VALUES ('20', '2018');

-- ----------------------------
-- Table structure for `_school`
-- ----------------------------
DROP TABLE IF EXISTS `_school`;
CREATE TABLE `_school` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `scname` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `address` text,
  `leader` varchar(255) DEFAULT NULL,
  `leaderPhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _school
-- ----------------------------
INSERT INTO `_school` VALUES ('00000000000000000001', 'wq(系统管理员)', '2018-05-02 14:20:05', 'admin009', '2018-05-16 11:59:09', '1', '18', '山东济南总校区', '北大青鸟尚学堂', '山东', '五院军泰写字楼~~', '陈校长', '13112312311');
INSERT INTO `_school` VALUES ('00000000000000000002', 'wq(系统管理员)', '2018-05-02 14:22:18', 'wq(系统管理员)', '2018-05-02 14:22:28', '1', '1', '河北石家庄校区', '北大青鸟尚学堂', '河北', '石家庄路1号', '褚老师', '13112312312');
INSERT INTO `_school` VALUES ('00000000000000000004', 'wq（admin）', '2018-05-09 13:49:31', 'wq（admin）', '2018-05-09 13:49:38', '1', '1', '测试00012', '北大青鸟尚学堂', '山东', '山豆根山豆根', '', '');

-- ----------------------------
-- Table structure for `_stu_clazz`
-- ----------------------------
DROP TABLE IF EXISTS `_stu_clazz`;
CREATE TABLE `_stu_clazz` (
  `stuId` bigint(20) NOT NULL DEFAULT '0',
  `clazzId` bigint(20) NOT NULL DEFAULT '0',
  `createBy` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `AK_stu_class_pk` (`stuId`,`clazzId`)
) ENGINE=InnoDB AUTO_INCREMENT=1044 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _stu_clazz
-- ----------------------------
INSERT INTO `_stu_clazz` VALUES ('1', '1', null, null, '1');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'wq（admin）', '2018-05-04 17:26:17', '2');
INSERT INTO `_stu_clazz` VALUES ('2', '3', 'wq（admin）', '2018-05-07 12:23:37', '3');
INSERT INTO `_stu_clazz` VALUES ('2', '7', 'wq（admin）', '2018-05-04 17:29:08', '4');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'wq（admin）', '2018-05-07 13:10:57', '5');
INSERT INTO `_stu_clazz` VALUES ('0', '0', null, null, '6');
INSERT INTO `_stu_clazz` VALUES ('6', '3', 'wq（admin）', '2018-05-09 14:20:12', '7');
INSERT INTO `_stu_clazz` VALUES ('0', '0', null, null, '1000');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-21 12:15:45', '1001');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'admin009', '2018-05-21 12:18:37', '1002');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'admin009', '2018-05-21 12:19:03', '1003');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'admin009', '2018-05-21 12:19:42', '1004');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'admin009', '2018-05-21 12:21:20', '1005');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'admin009', '2018-05-21 12:21:57', '1006');
INSERT INTO `_stu_clazz` VALUES ('7', '1', 'wq2000', '2018-05-21 12:26:59', '1007');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-21 14:53:49', '1008');
INSERT INTO `_stu_clazz` VALUES ('8', '1', 'admin009', '2018-05-22 15:14:31', '1009');
INSERT INTO `_stu_clazz` VALUES ('9', '1', 'admin009', '2018-05-22 16:17:47', '1010');
INSERT INTO `_stu_clazz` VALUES ('10', '3', 'wq2000', '2018-05-23 16:29:47', '1011');
INSERT INTO `_stu_clazz` VALUES ('10', '6', 'admin009', '2018-05-23 16:30:38', '1012');
INSERT INTO `_stu_clazz` VALUES ('11', '1', 'admin009', '2018-05-25 12:03:16', '1013');
INSERT INTO `_stu_clazz` VALUES ('12', '1', 'wq2001', '2018-05-25 12:06:46', '1014');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 10:51:02', '1026');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 10:53:22', '1027');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 10:55:18', '1028');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:01:27', '1030');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:05:23', '1032');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:08:23', '1034');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:09:58', '1035');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:16:35', '1036');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:18:10', '1037');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:25:00', '1038');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:25:12', '1039');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:25:20', '1040');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:25:42', '1041');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:25:52', '1042');
INSERT INTO `_stu_clazz` VALUES ('2', '1', 'admin009', '2018-05-28 11:26:15', '1043');

-- ----------------------------
-- Table structure for `_stu_consult`
-- ----------------------------
DROP TABLE IF EXISTS `_stu_consult`;
CREATE TABLE `_stu_consult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stuId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL DEFAULT '0',
  `lastLockTime` datetime DEFAULT NULL,
  `quizTime` datetime DEFAULT NULL,
  `firstVisit` text,
  `secondVisit` text,
  `thirdVisit` text,
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `remarks` text,
  `purpose` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _stu_consult
-- ----------------------------
INSERT INTO `_stu_consult` VALUES ('2', '7', '12', '2018-05-25 17:25:00', '2018-05-10 16:04:14', '1', '2', '3', 'wq2000', '2018-05-22 15:04:04', 'wq2000', '2018-05-23 17:25:00', '12', '12', '4', '1');
INSERT INTO `_stu_consult` VALUES ('3', '8', '12', '2018-05-23 17:15:16', '2018-05-25 14:17:12', 'test1', 'test2', 'test3', 'wq2000', '2018-05-22 15:14:59', 'wq2000', '2018-05-23 17:15:16', '12', '12', 'test remarks', '2');
INSERT INTO `_stu_consult` VALUES ('5', '10', '12', '2018-05-25 12:08:25', '2018-05-25 16:03:01', '1', '2', '3', 'wq2000', '2018-05-23 16:30:55', 'wq2000', '2018-05-25 12:08:25', '12', '12', '4', '1');
INSERT INTO `_stu_consult` VALUES ('7', '9', '20', '2018-05-23 17:14:01', '2018-05-25 17:13:57', '', '', '', 'wq2000', '2018-05-23 17:09:47', 'wq2000', '2018-05-23 17:14:01', '12', '12', '', '0');
INSERT INTO `_stu_consult` VALUES ('8', '11', '12', '2018-05-25 12:04:37', null, null, null, null, 'wq2000', '2018-05-25 12:04:37', 'wq2000', '2018-05-25 12:04:37', '12', '12', null, '0');

-- ----------------------------
-- Table structure for `_student`
-- ----------------------------
DROP TABLE IF EXISTS `_student`;
CREATE TABLE `_student` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `stuName` varchar(255) DEFAULT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `schoolTime` date DEFAULT NULL,
  `gradutionTime` date DEFAULT NULL,
  `gradutionFrom` varchar(255) DEFAULT NULL,
  `gradutionRecord` varchar(255) DEFAULT NULL,
  `foreignLevel` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createByUsername` varchar(255) DEFAULT NULL,
  `contactorPhone` varchar(255) DEFAULT NULL,
  `remarks` text,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `computerSkill` varchar(255) DEFAULT NULL,
  `currentClazzId` bigint(20) DEFAULT NULL,
  `contactor` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _student
-- ----------------------------
INSERT INTO `_student` VALUES ('00000000000000000002', '李磊', '31111111111111', '13712312311', 'MAIL', null, null, '山东轻工业大学', '本科', '六级', '1', '', 'wq（admin）', '', '有希望来试听！！！', '2018-05-04 17:26:17', 'admin009', '2018-05-28 11:26:08', '1', '18', '二级', '1', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000006', 'asdffsd', '', '13311111111', 'MAIL', null, null, '', '大专', '未达标', '', '', 'wq（admin）', '', '', '2018-05-09 14:20:12', 'wq（admin）', '2018-05-09 14:20:12', '1', '1', '未达标', '3', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000007', '小马哥', '', '13793415312', 'MAIL', null, null, '', '大专', '未达标', '', '', 'admin009', '', '', '2018-05-21 12:18:36', 'wq2000', '2018-05-21 12:26:58', '18', '12', '未达标', '1', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000008', '李凡', '', '15975424321', 'MAIL', '2018-05-17', null, '', '大专', '四级', '', '', 'admin009', '', '', '2018-05-22 15:14:31', 'admin009', '2018-05-22 15:14:31', '18', '18', '未达标', '1', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000009', '李勇', '', '15612443141', 'MAIL', null, null, '', '本科', '四级', '', '', 'admin009', '', '', '2018-05-22 16:17:47', 'admin009', '2018-05-22 16:17:47', '18', '18', '未达标', '1', '', '试听');
INSERT INTO `_student` VALUES ('00000000000000000010', 'test007', '', '13234554311', 'MAIL', null, null, '', '大专', '未达标', '', '', 'wq2000', '', '', '2018-05-23 16:29:47', 'admin009', '2018-05-23 16:30:38', '12', '18', '一级', '6', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000011', 'test008', '', '13213124514', 'MAIL', null, null, '', '大专', '未达标', '', '', 'admin009', '', '', '2018-05-25 12:03:15', 'admin009', '2018-05-25 12:03:15', '18', '18', '未达标', '1', '', '咨询');
INSERT INTO `_student` VALUES ('00000000000000000012', '李磊', '', '18909414321', 'MAIL', null, null, '', '大专', '未达标', '', '', 'wq2001', '', '', '2018-05-25 12:06:46', 'wq2001', '2018-05-25 12:06:46', '20', '20', '未达标', '1', '', '咨询');

-- ----------------------------
-- Table structure for `_systemrole`
-- ----------------------------
DROP TABLE IF EXISTS `_systemrole`;
CREATE TABLE `_systemrole` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `roleName` varchar(255) DEFAULT NULL,
  `description` text,
  `departmentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleNameIndex` (`roleName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2038 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _systemrole
-- ----------------------------
INSERT INTO `_systemrole` VALUES ('00000000000000002002', 'wq(系统管理员)', '2018-05-02 14:41:06', 'admin009', '2018-05-15 11:43:50', '1', '18', '教员', '', '1003');
INSERT INTO `_systemrole` VALUES ('00000000000000002005', 'admin009', '2018-05-12 17:34:10', 'admin009', '2018-05-15 11:26:39', '18', '18', '就业专员', '就业~~', '1001');
INSERT INTO `_systemrole` VALUES ('00000000000000002011', 'admin009', '2018-05-15 09:49:29', 'admin009', '2018-05-15 11:41:55', '18', '18', '会计', '', '1005');
INSERT INTO `_systemrole` VALUES ('00000000000000002012', 'admin009', '2018-05-15 09:49:40', 'admin009', '2018-05-15 11:42:06', '18', '18', '出纳', '', '1005');
INSERT INTO `_systemrole` VALUES ('00000000000000002014', 'admin009', '2018-05-15 11:24:29', 'admin009', '2018-05-15 11:24:29', '18', '18', '中心校长', '', '1006');
INSERT INTO `_systemrole` VALUES ('00000000000000002015', 'admin009', '2018-05-15 11:25:05', 'admin009', '2018-05-15 11:25:05', '18', '18', '竞价专员', '', '1000');
INSERT INTO `_systemrole` VALUES ('00000000000000002016', 'admin009', '2018-05-15 11:25:16', 'admin009', '2018-05-15 11:25:16', '18', '18', '在线咨询师', '', '1000');
INSERT INTO `_systemrole` VALUES ('00000000000000002017', 'admin009', '2018-05-15 11:25:40', 'admin009', '2018-05-15 11:25:40', '18', '18', '咨询主管', '', '1000');
INSERT INTO `_systemrole` VALUES ('00000000000000002018', 'admin009', '2018-05-15 11:25:48', 'admin009', '2018-05-15 11:25:48', '18', '18', '咨询师', '', '1000');
INSERT INTO `_systemrole` VALUES ('00000000000000002019', 'admin009', '2018-05-15 11:26:06', 'admin009', '2018-05-15 11:26:06', '18', '18', '咨询助理', '', '1000');
INSERT INTO `_systemrole` VALUES ('00000000000000002020', 'admin009', '2018-05-15 11:26:46', 'admin009', '2018-05-15 11:26:46', '18', '18', '就业部经理', '', '1001');
INSERT INTO `_systemrole` VALUES ('00000000000000002021', 'admin009', '2018-05-15 11:27:14', 'admin009', '2018-05-15 11:27:14', '18', '18', '市场活动主管', '', '1002');
INSERT INTO `_systemrole` VALUES ('00000000000000002022', 'admin009', '2018-05-15 11:27:23', 'admin009', '2018-05-15 11:27:23', '18', '18', '市场活动专员', '', '1002');
INSERT INTO `_systemrole` VALUES ('00000000000000002023', 'admin009', '2018-05-15 11:27:47', 'admin009', '2018-05-15 11:27:47', '18', '18', '电话销售专员', '', '1002');
INSERT INTO `_systemrole` VALUES ('00000000000000002027', 'admin009', '2018-05-15 11:40:39', 'admin009', '2018-05-15 11:40:39', '18', '18', '学术部经理', '', '1003');
INSERT INTO `_systemrole` VALUES ('00000000000000002028', 'admin009', '2018-05-15 11:42:30', 'admin009', '2018-05-15 11:42:30', '18', '18', '行政专员', '', '1005');
INSERT INTO `_systemrole` VALUES ('00000000000000002029', 'admin009', '2018-05-15 11:42:40', 'admin009', '2018-05-15 11:42:40', '18', '18', '人事专员', '', '1005');
INSERT INTO `_systemrole` VALUES ('00000000000000002030', 'admin009', '2018-05-15 11:44:31', 'admin009', '2018-05-15 11:44:31', '18', '18', '教务', '', '1007');
INSERT INTO `_systemrole` VALUES ('00000000000000002032', 'admin009', '2018-05-15 11:45:10', 'admin009', '2018-05-15 11:45:10', '18', '18', '班主任', '', '1007');
INSERT INTO `_systemrole` VALUES ('00000000000000002033', 'admin009', '2018-05-15 11:46:06', 'admin009', '2018-05-15 11:46:06', '18', '18', '网络主管', '', '1008');
INSERT INTO `_systemrole` VALUES ('00000000000000002034', 'admin009', '2018-05-15 11:46:19', 'admin009', '2018-05-15 11:46:19', '18', '18', '技术顾问', '', '1008');
INSERT INTO `_systemrole` VALUES ('00000000000000002035', 'admin009', '2018-05-15 11:46:28', 'admin009', '2018-05-15 11:46:28', '18', '18', '技术支持', '', '1008');
INSERT INTO `_systemrole` VALUES ('00000000000000002036', 'admin009', '2018-05-15 11:46:55', 'admin009', '2018-05-15 11:46:55', '18', '18', '教质部经理', '', '1008');
INSERT INTO `_systemrole` VALUES ('00000000000000002037', 'admin009', '2018-05-15 11:52:13', 'admin009', '2018-05-15 11:52:13', '18', '18', '辅导员', '', '1003');

-- ----------------------------
-- Table structure for `_user`
-- ----------------------------
DROP TABLE IF EXISTS `_user`;
CREATE TABLE `_user` (
  `id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '�û���Ϣ��',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `createByUsername` varchar(255) DEFAULT NULL,
  `createOn` datetime DEFAULT NULL,
  `updateByUsername` varchar(255) DEFAULT NULL,
  `updateOn` datetime DEFAULT NULL,
  `createByUserId` bigint(20) DEFAULT '0',
  `updateByUserId` bigint(20) DEFAULT '0',
  `isAdmin` tinyint(11) DEFAULT NULL,
  `isLeader` tinyint(11) DEFAULT NULL,
  `schoolId` bigint(20) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `schoolIdIndex` (`schoolId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of _user
-- ----------------------------
INSERT INTO `_user` VALUES ('00000000000000000002', 'jm', '$2a$10$EMN4vRo/KJa4T8UdgPVF.OW1D19TffkB7e4gIPRauAFO5Ipld.f8i', '金民', '', '张100@qq.com', 'MAIL', '13605510796', 'ACTIVE', '2018-05-02 00:00:00', 'wq', '2018-05-02 14:44:12', 'wq（admin）', '2018-05-09 13:38:18', '0', '1', '0', '0', '1', '101');
INSERT INTO `_user` VALUES ('00000000000000000003', 'lkd', '$2a$10$x6NfhGWKX3exeyw.w7dxdujkkYZIQxu4algwmGLuufhVf/jdusWFS', '李坤栋', null, '张101@qq.com', 'MAIL', '13002615612', 'ACTIVE', '2018-05-02 00:00:00', 'wq', '2018-05-02 14:44:13', 'wq', '2018-05-02 14:44:13', '0', '0', '0', '0', '2', '101');
INSERT INTO `_user` VALUES ('00000000000000000004', 'ltl', '$2a$10$OCGku0KM1ts3ZD9MWibTd.1Oc5BEC9bweoYJuZ4vX7hdJckZ3nx8q', '卢天立', null, '张102@qq.com', 'MAIL', '15606136347', 'ACTIVE', '2018-05-02 00:00:00', 'wq', '2018-05-02 14:44:13', 'wq', '2018-05-02 14:44:13', '0', '0', '0', '0', '1', '101');
INSERT INTO `_user` VALUES ('00000000000000000005', 'ls105', '$2a$10$WHCIhSXFJ7oKPpAc1/GVkOaSOsuurE9viWF7IFYV.e5/FIdKUuKGS', '李105', null, '李105@qq.com', 'MAIL', '13400838705', 'ACTIVE', '2018-05-03 00:00:00', 'wq', '2018-05-03 10:09:00', 'wq', '2018-05-03 10:09:00', '0', '0', '0', '0', '1', '101');
INSERT INTO `_user` VALUES ('00000000000000000006', 'zt', '$2a$10$L7YgTDXZ8gBemCugauT6.exr62f.NfafUXNe0TTO/1/ENLF2l0g7K', '周通', null, '李106@qq.com', 'MAIL', '13004688785', 'ACTIVE', '2018-05-03 00:00:00', 'wq', '2018-05-03 10:09:00', 'wq', '2018-05-03 10:09:00', '0', '0', '0', '0', '2', '101');
INSERT INTO `_user` VALUES ('00000000000000000010', 'wq2018', '$2a$10$DXv6nxq.FD4zFPREu.1qHeLLLsSmViZOTlVQXixfXIuGaZb2pQPrW', '猪八戒', '', 'wq@qq.cc', 'MAIL', '13121312397', 'ACTIVE', '2018-05-10 00:00:00', 'jm', '2018-05-10 15:30:31', 'admin009', '2018-05-21 12:17:08', '0', '18', '0', '0', '1', null);
INSERT INTO `_user` VALUES ('00000000000000000011', 'wq2019', '$2a$10$.kBGOIT/gBsyK.ZQOT1kZeaYVlYeboVxNs6gilpwFyPnpCrxLIDdC', '123123123g', '', 'wq@qq.cc', 'MAIL', '13126789654', 'ACTIVE', '2018-05-23 00:00:00', 'wq2018', '2018-05-10 15:39:18', 'admin009', '2018-05-23 15:30:26', '0', '18', '0', '0', '2', null);
INSERT INTO `_user` VALUES ('00000000000000000012', 'wq2000', '$2a$10$f4voiCiLPueXtA8LLstfa.C1P.7oH5Ld/KViCzaEYG/euXXsxBsAK', '丁虹', '', 'wasz@qq.cc', 'MAIL', '13112334565', 'ACTIVE', null, 'wq2018', '2018-05-11 11:34:17', 'admin009', '2018-05-21 16:45:45', '10', '18', '0', '0', '1', null);
INSERT INTO `_user` VALUES ('00000000000000000013', 'szcvsdf', '$2a$10$xcYQ7/r2dh/on9PGT241wuKqzgZULkCJoEW7AQUTrNGhprfrozszy', '旅人', '', 'wbvf@qq.cf', 'MAIL', '15412315432', 'ACTIVE', null, 'wq2018', '2018-05-11 11:39:58', 'admin009', '2018-05-21 16:42:42', '10', '18', '0', '0', '2', null);
INSERT INTO `_user` VALUES ('00000000000000000014', 'dbfibibg', '$2a$10$Mmpouh8NmiKq4Apz3xT2SORmhdNf5xFBTyPnY3hMzIfA3h7Z9J1Mu', 'fg敌法热费', '', '213@qq.cc', 'MAIL', '13345134123', 'ACTIVE', null, 'wq2018', '2018-05-11 11:57:14', 'wq2018', '2018-05-11 14:06:44', '10', '10', null, null, '1', '9');
INSERT INTO `_user` VALUES ('00000000000000000016', 'admin008', '$2a$10$1.0Vh9yTZuqGTdQ5AMob2etBOYx1Kpr1xl3km.p0WN1RdUJJVwneq', '校区经理XXX', '', 'sfadsf@qq.cc', 'MAIL', '13112312319', 'ACTIVE', null, 'wq2018', '2018-05-11 12:11:15', 'admin008', '2018-05-19 13:39:07', '10', '16', '0', '1', '2', null);
INSERT INTO `_user` VALUES ('00000000000000000018', 'admin009', '$2a$10$Pxb4BD3YFY20JvqadcTwCeXeZtDk/ck6t5t2FJLhH5fM9shioEcK2', '总部管理者XXX', '', 'ww@qq.cc', 'MAIL', '13196587321', 'ACTIVE', null, 'wq2018', '2018-05-11 15:43:44', 'wq2018', '2018-05-11 15:44:55', '10', '10', '1', '0', '1', null);
INSERT INTO `_user` VALUES ('00000000000000000019', 'test006', '$2a$10$qlQsKnAj.2O0Rk0n2w1x8.BXkU5PI1ZxGFtqRc8uIMBefzR0oJkKa', '张三159', '', 'wq@qq.cc', 'MAIL', '15987645324', 'ACTIVE', null, 'admin009', '2018-05-15 10:02:42', 'admin009', '2018-05-15 10:02:59', '18', '18', '0', '0', '1', '1005');
INSERT INTO `_user` VALUES ('00000000000000000020', 'wq2001', '$2a$10$V77AyJYntpSSid/tG6vuvu351TXYpH0JkXEMArTujYDcokjPWEZ/y', '张海燕', '', 'zhy@qq.com', 'MAIL', '18762341233', 'ACTIVE', '2018-05-23 00:00:00', 'admin009', '2018-05-21 16:46:27', 'admin009', '2018-05-21 16:46:27', '18', '18', '0', '0', '1', null);


alter table _department auto_increment=1100;
alter table _systemrole auto_increment=5000;
alter table _doc auto_increment=500;
alter table _doccat auto_increment=170;
