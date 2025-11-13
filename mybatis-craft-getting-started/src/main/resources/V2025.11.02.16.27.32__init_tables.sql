CREATE DATABASE IF NOT EXISTS mybatis_craft;

USE mybatis_craft;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` ( `username`, `password`, `birthday`, `gender`, `email` )
VALUES
    ( '张三', 'zhangsan123', '1985-03-15', '男', 'zhangsan@example.com' ),
    ( '李四', 'lisi456', '1990-07-22', '男', 'lisi@example.com' ),
    ( '王五', 'wangwu789', '1992-11-05', '男', 'wangwu@example.com' ),
    ( '赵六', 'zhaoliu321', '1988-05-18', '男', 'zhaoliu@example.com' ),
    ( '孙七', 'sunqi654', '1995-09-30', '女', 'sunqi@example.com' ),
    ( '周八', 'zhouba987', '1993-02-14', '女', 'zhouba@example.com' ),
    ( '吴九', 'wujiu258', '1987-08-08', '男', 'wujiu@example.com' ),
    ( '郑十', 'zhengshi147', '1998-04-20', '女', 'zhengshi@example.com' ),
    ( '钱十一', 'qianshiyi369', '1991-12-01', '男', 'qianshiyi@example.com' ),
    ( '孙十二', 'sunshier852', '1996-06-12', '女', 'sunshier@example.com' );

SET FOREIGN_KEY_CHECKS = 1;