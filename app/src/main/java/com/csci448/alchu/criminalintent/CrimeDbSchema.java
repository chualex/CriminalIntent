package com.csci448.alchu.criminalintent;

/**
 * Created by Alex on 3/19/18.
 */

public class CrimeDbSchema {

        public static final class CrimeTable {
            public static final String NAME = "crimes";

            public static final class Cols {
                public static final String UUID = "uuid";
                public static final String TITLE = "title";
                public static final String DATE = "date";
                public static final String SOLVED = "solved";
                public static final String SUSPECT = "suspect";
                public static final String PHONE_NUMBER = "phone_number";
            }
        }

}
