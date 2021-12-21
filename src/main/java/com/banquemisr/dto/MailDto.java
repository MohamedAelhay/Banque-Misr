package com.banquemisr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
    private String mailFrom;

    private String mailTo;

    private String mailCc;

    private String mailSubject;

    private String mailContent;

    private String contentType = "text/plain";
}
