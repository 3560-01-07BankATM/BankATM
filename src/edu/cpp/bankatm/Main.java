package edu.cpp.bankatm;

import edu.cpp.bankatm.dao.DB;

public class Main {

    public static void main(String[] args) throws Exception {
        DB.init();
        Controller.init();
    }
}
