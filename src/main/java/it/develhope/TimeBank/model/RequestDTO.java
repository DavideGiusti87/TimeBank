package it.develhope.TimeBank.model;

/**
 * This class is used to submit a request to the system.
 * When received, RequestDTO has to be processed and transformed into a Request entity:
 * - contact information has to be populated as described below;
 * - area has to be validated into an appropriate enume
 * - requiredSkills has to be transformed into a List<Skill>
 */
public class    RequestDTO {

    // CONTACT INFO
    /*
    useDefaultUserContactInformation identify an ANONYMOUS REQUEST:
    - if it's true, the user has to be logged in and the controller will use User's contact info to populate
      contact's fields;
    - if it's false, the user can or cannot be logged in; but contact info will be taken from the RequestDTO
      and therefore are mandatory - if missing, an error will be returned.
     */
    private boolean useDefaultUserContactInformation;
    private String username;
    private String phoneNumber;
    private String email;
    // OTHER INFO
    private String description;
    private Area area;
    // if one or more of the provided string doesn't correspond to a skill an error message will be returned
    // ALTERNATIVELY --> when a new skill is submitted, a new skill can be created
    private String[] requiredSkills;

    public RequestDTO() {
    }

    public RequestDTO(boolean useDefaultUserContactInformation, String username, String mainContact, String secondaryContact, String description, Area area, String[] requiredSkills) {
        this.useDefaultUserContactInformation = useDefaultUserContactInformation;
        this.username = username;
        this.phoneNumber = mainContact;
        this.email = secondaryContact;
        this.description = description;
        this.area = area;
        this.requiredSkills = requiredSkills;
    }

    public boolean isUseDefaultUserContactInformation() {
        return useDefaultUserContactInformation;
    }

    public void setUseDefaultUserContactInformation(boolean useDefaultUserContactInformation) {
        this.useDefaultUserContactInformation = useDefaultUserContactInformation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String[] getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String[] requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
