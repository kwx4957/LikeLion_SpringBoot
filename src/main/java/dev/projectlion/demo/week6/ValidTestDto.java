package dev.projectlion.demo.week6;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ValidTestDto {
    @NotNull // null 여부 체크 null 또는 변수값
    private String notnullSting;
    @NotEmpty // "" 값은 있지만 내용물이 없는 경우 , null이 아니면서 Object.Size() > 0 큰 경우
    private String notEmptyString;
    @NotBlank //공백이 아닌 문자열 "    "
    private String notBlankString;

    @NotEmpty
    private List<String> notEmptyStringList;

}

