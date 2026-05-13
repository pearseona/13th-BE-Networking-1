package cotato.backend.domain.applicant.dto;

import cotato.backend.domain.entity.Applicant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApplicantResponse {
    private String name;
    private int age;
    private String phoneNumber;

    public static ApplicantResponse from(Applicant applicant) {
        return ApplicantResponse.builder()
                .name(applicant.getName())
                .age(applicant.getAge())
                .phoneNumber(applicant.getPhoneNumber())
                .build();
    }
}
