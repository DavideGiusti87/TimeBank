package it.develhope.TimeBank.model;

public class RequestDTO {

    private String title;
    private String description;
    private Long areaId;
    private Long[] skillIds;

    public RequestDTO() {
    }

    public RequestDTO(String title, String description, Long areaId, Long[] skillIds) {
        this.title = title;
        this.description = description;
        this.areaId = areaId;
        this.skillIds = skillIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long[] getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(Long[] skillIds) {
        this.skillIds = skillIds;
    }
}
