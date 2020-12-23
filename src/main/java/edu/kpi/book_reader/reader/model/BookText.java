package edu.kpi.book_reader.reader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_texts")
public class BookText {
    @Id
    private Integer bookId;
    @Column
    private String text;
}
