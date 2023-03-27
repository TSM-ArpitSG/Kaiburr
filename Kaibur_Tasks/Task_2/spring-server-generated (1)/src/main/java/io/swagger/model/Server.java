package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Server
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-26T20:09:08.116918182Z[GMT]")


public class Server   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("framework")
  private String framework = null;

  public Server name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Server id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Server language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Server framework(String framework) {
    this.framework = framework;
    return this;
  }

  /**
   * Get framework
   * @return framework
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFramework() {
    return framework;
  }

  public void setFramework(String framework) {
    this.framework = framework;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Server server = (Server) o;
    return Objects.equals(this.name, server.name) &&
        Objects.equals(this.id, server.id) &&
        Objects.equals(this.language, server.language) &&
        Objects.equals(this.framework, server.framework);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, language, framework);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Server {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    framework: ").append(toIndentedString(framework)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
