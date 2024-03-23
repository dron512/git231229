package com.mh.restapi05.file;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDto {
    private String fileName;
    private String myName;
    private String age;

    public FileDto(String fileName) {
        this.fileName = fileName;
    }
}
