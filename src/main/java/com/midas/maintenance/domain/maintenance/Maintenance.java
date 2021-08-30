package com.midas.maintenance.domain.maintenance;

import com.midas.maintenance.domain.BaseTimeEntity;
import com.midas.maintenance.domain.custom.Custom;
import com.midas.maintenance.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Maintenance extends BaseTimeEntity {
    /**
     * id,
     * CustomId, CustomName,
     * RequestTel, RequestDate,
     * RequestorId, Requestor
     * RequestType(문의/오류/.../기타), RequestContent,
     * ProgramType, ProgramName,
     * PIC(The person in charge),
     * IsRepairCost, RepairCost,
     * Status(접수/진행중/완료),
     * ErrorCode(PC/Network/로그인/조회/저장/삭제/.../기타), ErrorName, ErrorDetails
     * CompletionDate, CompletionDetails
     * Comments
     */
    @Id
    @GeneratedValue
    @Column(name = "maintenance_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "custom_id")
    private Custom custom;

    @Enumerated(EnumType.STRING)
    private RequestType requestType;
    private String requestDate;
    private String requestTel;
    private String requestContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "member_id")
    private Member requestor;

    @Enumerated(EnumType.STRING)
    private ProgramType programType;
    private String programName;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "member_id")
    private Member pic;

    private boolean isRepairCost;
    private int repairCost;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private ErrorType errorType;
    private String errorName;
    private String errorDetails;

    private String completionDate;
    private String completionDetails;

    private String comments;

    @Builder
    public Maintenance(Custom custom, RequestType requestType, String requestDate, String requestTel, String requestContent,
                       Member requestor, ProgramType programType, String programName, Member pic, boolean isRepairCost,
                       int repairCost, Status status, ErrorType errorType, String errorName, String errorDetails,
                       String completionDate, String completionDetails, String comments) {
        this.custom = custom;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.requestTel = requestTel;
        this.requestContent = requestContent;

        this.requestor = requestor;
        this.programType = programType;
        this.programName = programName;
        this.pic = pic;
        this.isRepairCost = isRepairCost;

        this.repairCost = repairCost;
        this.status = status;
        this.errorType = errorType;
        this.errorName = errorName;
        this.errorDetails = errorDetails;

        this.completionDate = completionDate;
        this.completionDetails = completionDetails;
        this.comments = comments;
    }


    //== 비지니스 로직 ==//
    // 변경
    public void update(Custom custom, RequestType requestType, String requestDate, String requestTel, String requestContent,
                       Member requestor, ProgramType programType, String programName, Member pic, boolean isRepairCost,
                       int repairCost, Status status, ErrorType errorType, String errorName, String errorDetails,
                       String completionDate, String completionDetails, String comments) {
        this.custom = custom;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.requestTel = requestTel;
        this.requestContent = requestContent;

        this.requestor = requestor;
        this.programType = programType;
        this.programName = programName;
        this.pic = pic;
        this.isRepairCost = isRepairCost;

        this.repairCost = repairCost;
        this.status = status;
        this.errorType = errorType;
        this.errorName = errorName;
        this.errorDetails = errorDetails;

        this.completionDate = completionDate;
        this.completionDetails = completionDetails;
        this.comments = comments;
    }

    // 상태값
    public void setStatusToProceed() {
        status = Status.PROCEEDING;
    }

    public void setStatusToCompleteion(String completionDate, String completionDetails) {
        status = Status.COMPLETION;
        this.completionDate = completionDate;
        this.completionDetails = completionDetails;
    }

}
