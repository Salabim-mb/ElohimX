package utils;

import javafx.util.StringConverter;

public class ToIntConverter extends StringConverter<Integer>{

        @Override
        public String toString(Integer object) {
            return object + "";
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }


}








