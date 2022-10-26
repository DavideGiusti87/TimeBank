package it.develhope.TimeBank.model;

public class AnonymousRequestDTO {

    /*{
        "title": "Lavatrice rotta",
        "description": "La mia lavatrice non scarica, forse si è intasato il tubo",
        "contactName": "Carlo",
        "telephoneNumber": "+39123456789",
        "email": "carlo.casiglia@gmail.com",
        "areaId": "4",
        "skills": ["12", "18", "24"]
    }*/

    private String title;
    private String description;
    private String contactName;
    private String telephoneNumber;
    private String email;
    private Long areaId;
    private Long[] skillIds;

    public AnonymousRequestDTO() {
    }

    public AnonymousRequestDTO(String title, String description, String contactName, String telephoneNumber, String email, Long areaId, Long[] skillIds) {
        this.title = title;
        this.description = description;
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
