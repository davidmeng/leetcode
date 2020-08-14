package com.company;

public class TestMove {

    public static void main(String[] args) {
        String[] folders = {"aldi", "b2b", "cp", "mapp", "mapp_reopen_mp", "mapp_reopen_po", "o2o", "ps"};
        for (String folder : folders) {
            for (int i = 9; i <= 28; i++) {
                System.out.printf("mv %s %s \r\n", getPath(true, folder, i), getPath(false, folder, i));
            }
        }
    }

    public static String getPath(boolean from, String basePath, int date) {
        String base = null;
        if (from) {
            base = "/opt/coe_nfs/moweb_output_nfs/";
            base += basePath;
        } else {
            base = "/opt/coe_nfs/moweb_output_nas_2/";
            base += basePath;
        }

        if (date < 10) {
            base += "/2020-05-0" + date;
        } else {
            base += "/2020-05-" + date;
        }

        return base;
    }
}
