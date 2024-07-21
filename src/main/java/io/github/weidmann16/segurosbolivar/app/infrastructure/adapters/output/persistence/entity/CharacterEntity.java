package io.github.weidmann16.segurosbolivar.app.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "characters")
public class CharacterEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private String status;

  @Column(name = "species")
  private String species;

  @Column(name = "type")
  private String type;

  @Column(name = "gender")
  private String gender;

  @Embedded
  private OriginEntity origin;

  @Embedded
  private LocationEntity location;

  @Column(name = "image")
  private String image;

  @ElementCollection
  @CollectionTable(name = "character_episodes", joinColumns = @JoinColumn(name = "character_id"))
  @Column(name = "episode")
  private List<String> episode;

  @Column(name = "url")
  private String url;

  @Column(name = "created")
  private String created;

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @Embeddable
  public static class OriginEntity {
      @Column(name = "origin_name")
      private String name;
      @Column(name = "origin_url")
      private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @Embeddable
  public static class LocationEntity {
      @Column(name = "location_name")
      private String name;
      @Column(name = "location_url")
      private String url;
  }
}
