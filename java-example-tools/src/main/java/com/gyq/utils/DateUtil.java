package com.gyq.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author gaoyaqiu
 * @since 1.8
 */
public class DateUtil {
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    public static final DateTimeFormatter SHORT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter SHORT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter MILLI_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 返回当前的日期
     *
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     *
     * @return
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }


    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }


    public static String getCurrentShortDateStr() {
        return LocalDate.now().format(SHORT_DATE_FORMATTER);
    }

    public static String getCurrentMonthStr() {
        return LocalDate.now().format(MONTH_FORMATTER);
    }


    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }


    public static String getCurrentShortDateTimeStr() {
        return LocalDateTime.now().format(SHORT_DATETIME_FORMATTER);
    }

    public static String getCurrentTimeStr() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    public static String getCurrentDateStr(String pattern) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentDateTimeStr(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getCurrentTimeStr(String pattern) {
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalTime parseLocalTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalDateTime(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatLocalTime(LocalTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalTime parseLocalTime(String timeStr) {
        return LocalTime.parse(timeStr, TIME_FORMATTER);
    }

    public static String formatLocalDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static String formatLocalDateTime(LocalDateTime datetime) {
        return datetime.format(DATETIME_FORMATTER);
    }

    public static String formatLocalTime(LocalTime time) {
        return time.format(TIME_FORMATTER);
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static long periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return endDateExclusive.toEpochDay() - startDateInclusive.toEpochDay();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取此日期时间与默认时区<Asia/Shanghai>组合的时间毫秒数
     *
     * @param dateTime
     * @return
     */
    public static Long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取此日期时间与指定时区组合的时间毫秒数
     *
     * @param dateTime
     * @return
     */
    public static Long toSelectEpochMilli(LocalDateTime dateTime, ZoneId zoneId) {
        return dateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public static String convertTimeToString(Long time) {
        Assert.notNull(time, "time is null");
        return DATETIME_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式(yyyy-MM-dd HH:mm:ss:SSS)
     */
    public static String convertTimeToStringMilli(Long time) {
        Assert.notNull(time, "time is null");
        return MILLI_DATETIME_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    public static Date getCurrentDate() {
        LocalDateTime currentLocalDateTime = getCurrentLocalDateTime();
        Instant instant = currentLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Date getDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static String convertZoneTimeToString(Integer time) {
        Assert.notNull(time, "time is null");
        String localDate = DATE_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault()));
        String localTime = TIME_FORMATTER.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault()));
        return localDate + "T" + localTime + ".000" + OffsetDateTime.now().getOffset();
    }

    public static boolean isValid(String input) {

        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseStrict().toFormatter();
        try {
            LocalDate.parse(input, dateTimeFormatter);
            return true;
        } catch (DateTimeException e) {

        }
        return false;
    }

    /**
     * 判断当前时间是否在目标时间之前（当前时间小于目标时间）
     *
     * @param targetTime 待比较时间（格式：2019-10-13T23:59:59+08:00）
     * @return
     */
    public static boolean isBeforTime(String targetTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(targetTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return LocalDateTime.now().isBefore(localDateTime);
    }


    /**
     * 判断当前时间是否在目标时间之后（当前时间大于目标时间）
     *
     * @param targetTime 待比较时间（格式：2019-10-13T23:59:59+08:00）
     * @return
     */
    public static boolean isAfterTime(String targetTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(targetTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return LocalDateTime.now().isAfter(localDateTime);
    }
}
