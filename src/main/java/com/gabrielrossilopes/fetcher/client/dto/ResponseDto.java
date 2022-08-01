package com.gabrielrossilopes.fetcher.client.dto;

public class ResponseDto {
    public static class Info {
        public int count;
        public int pages;
        public String next;
        public String prev;
    }

    public Info info;
    public Object[] results;
}
