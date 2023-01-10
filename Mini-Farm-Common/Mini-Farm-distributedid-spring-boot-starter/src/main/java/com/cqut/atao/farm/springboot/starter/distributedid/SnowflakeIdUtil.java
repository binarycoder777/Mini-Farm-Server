//package com.cqut.atao.farm.springboot.starter.distributedid;
//
///**
// * @author atao
// * @version 1.0.0
// * @ClassName SnowflakeIdUtil.java
// * @Description 分布式雪花 ID 生成器
// * @createTime 2023年01月10日 18:29:00
// */
//public final class SnowflakeIdUtil {
//
//    /**
//     * 雪花算法对象
//     */
//    private static Snowflake SNOWFLAKE;
//
//    /**
//     * 初始化雪花算法
//     */
//    public static void initSnowflake(Snowflake snowflake) {
//        SnowflakeIdUtil.SNOWFLAKE = snowflake;
//    }
//
//    /**
//     * 获取雪花算法实例
//     */
//    public static Snowflake getInstance() {
//        return SNOWFLAKE;
//    }
//
//    /**
//     * 获取雪花算法下一个 ID
//     */
//    public static long nextId() {
//        return SNOWFLAKE.nextId();
//    }
//
//    /**
//     * 获取雪花算法下一个字符串类型 ID
//     */
//    public static String nextIdStr() {
//        return Long.toString(nextId());
//    }
//
//    /**
//     * 解析雪花算法生成的 ID 为对象
//     */
//    public static SnowflakeIdInfo parseSnowflakeId(String snowflakeId) {
//        return SNOWFLAKE.parseSnowflakeId(Long.parseLong(snowflakeId));
//    }
//
//    /**
//     * 解析雪花算法生成的 ID 为对象
//     */
//    public static SnowflakeIdInfo parseSnowflakeId(long snowflakeId) {
//        return SNOWFLAKE.parseSnowflakeId(snowflakeId);
//    }
//}
//
