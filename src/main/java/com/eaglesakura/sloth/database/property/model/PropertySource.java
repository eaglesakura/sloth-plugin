package com.eaglesakura.sloth.database.property.model;

import com.google.gson.annotations.SerializedName;

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
        public String type;
    }

    /**
     * グルーピング
     */
    public static class Group {
        /**
         * プロパティ一覧
         */
        @SerializedName("properties")
        public List<Property> _properties;

        /**
         * グループ名
         */
        public String name;
    }
}
