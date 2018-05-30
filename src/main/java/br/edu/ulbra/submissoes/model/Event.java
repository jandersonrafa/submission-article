package br.edu.ulbra.submissoes.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Janderson
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;

	@Column(nullable = false)
	private String eventName;

	@Column(nullable = false)
	private LocalDate eventDate;

	@Column(nullable = false)
	private LocalDate registrationStartDate;

	@Column(nullable = false)
	private LocalDate registrationEndDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
