package com.eaglesakura.sloth.database.property.model;

import android.support.annotation.Keep;

import java.util.List;

/**
 * Text Key-Valueのデフォルト値を保持するJsonModel
 */
public class PropertySource {

    /**
     * 複数のプロパティを1ファイルで管理する
     */
    public List<Group> groups;

    /**
     * 1つのプロパティを管理する
     */
    public static class Property {
        /**
         * デフォルト値
         */
        public String value;

        /**
         * プロパティ名
         */
        public String name;

        /**
         * 型名, String, int, long等
         */
        @Keep
        public String type;
    }

    /**
     * グルーピング
     */
    public static class Group {
        /**
         * プロパティ一覧
         */
        @Keep
        public List<Property> properties;

        /**
         * グループ名
         */
        @Keep
        public String name;
    }
}
