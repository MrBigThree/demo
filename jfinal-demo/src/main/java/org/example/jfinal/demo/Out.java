package org.example.jfinal.demo;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.druid.DruidPlugin;

import java.util.ArrayList;
import java.util.List;

import static com.jfinal.plugin.activerecord.Db.find;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/8/14
 */
public class Out {

    public static void main(String[] args) {
        String dbName = "mybf";
        String outFile = "/Users/lvxuhong/Desktop/泵阀.xlsx";
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://20.21.1.102/information_schema?serverTimezone=Hongkong", "root", "zjrc2019");
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        dp.start();
        arp.start();
        List<Record> records = find("select TABLE_NAME,TABLE_COMMENT from TABLES where TABLE_SCHEMA = '" + dbName + "'");
//        List<List<String>> rows = new ArrayList<>();
//        List<String> firstHead = new ArrayList<>();
//        firstHead.add("业务系统名");
//        firstHead.add("表名");
//        firstHead.add("中文名");
//        firstHead.add("负责人");
//        rows.add(firstHead);
//        records.forEach(record -> {
//            List<String> row = new ArrayList<>();
//            row.add("");
//            row.add(record.getStr("TABLE_NAME"));
//            row.add(record.getStr("TABLE_COMMENT"));
//            row.add("胡晗");
//            rows.add(row);
//        });
//
//        //通过工具类创建writer
//        ExcelWriter writer = ExcelUtil.getWriter(outFile);
//        writer.autoSizeColumnAll();
//
//        //通过构造方法创建writer
//        writer.renameSheet(0, "业务系统清单");
//        writer.write(rows, true);
//        writer.merge(1, records.size(), 0, 0, "XX业务系统", true);
//
//        for (int i = 0; i < records.size(); i++) {
//            Record record = records.get(i);
//            String tableName = record.getStr("TABLE_NAME");
//            String tableComment = record.getStr("TABLE_COMMENT");
//            System.out.println(tableName + ":" + tableComment);
//            List<Record> columns = find("select COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE,IS_NULLABLE,CHARACTER_MAXIMUM_LENGTH from COLUMNS where TABLE_NAME = '" + tableName + "' order by ORDINAL_POSITION");
//            writer.setSheet(i + 1);
//            writer.renameSheet(tableName);
//
//            List<List<String>> rows1 = new ArrayList<>();
//            List<String> head = new ArrayList<>();
//            head.add("表名");
//            head.add(tableName);
//            rows1.add(head);
//            List<String> head2 = new ArrayList<>();
//            head2.add("序号");
//            head2.add("字段中文名（必填）");
//            head2.add("字段名称（必填）");
//            head2.add("数据类型（必填）");
//            head2.add("长度");
//            head2.add("非空？");
//            head2.add("分区键");
//            head2.add("详细描述");
//            rows1.add(head2);
//            for (int j = 0; j < columns.size(); j++) {
//                Record column = columns.get(j);
//                List<String> row = new ArrayList<>();
//                row.add(String.valueOf(j + 1));
//                row.add(column.getStr("COLUMN_COMMENT"));
//                row.add(column.getStr("COLUMN_NAME"));
//                row.add(column.getStr("DATA_TYPE"));
//                row.add(column.getStr("CHARACTER_MAXIMUM_LENGTH"));
//                String is_nullable = column.getStr("IS_NULLABLE");
//                String nullable;
//                if ("NO".equals(is_nullable)) {
//                    nullable = "Y";
//                } else {
//                    nullable = "N";
//                }
//                row.add(nullable);
//                row.add("");
//                row.add(column.getStr("COLUMN_COMMENT"));
//                rows1.add(row);
//            }
//            writer.write(rows1, true);
//        }
//        //关闭writer，释放内存
//        writer.close();
    }
}
