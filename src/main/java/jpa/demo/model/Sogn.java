package jpa.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Sogn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kode;
    private String navn;
    private LocalDate datoForNedlukning;
    private double smittetryk;
    @JsonManagedReference
    @OneToOne
    private Kommune kommune;

    public Sogn() {
    }

    public Sogn(int kode, String navn, LocalDate datoForNedlukning, double smittetryk) {
        this.kode = kode;
        this.navn = navn;
        this.datoForNedlukning = datoForNedlukning;
        this.smittetryk = smittetryk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int sognKode) {
        this.kode = sognKode;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String sognNavn) {
        this.navn = sognNavn;
    }

    public LocalDate getDatoForNedlukning() {
        return datoForNedlukning;
    }

    public void setDatoForNedlukning(LocalDate dato_for_nedlukning) {
        this.datoForNedlukning = dato_for_nedlukning;
    }

    public double getSmittetryk() {
        return smittetryk;
    }

    public void setSmittetryk(double smittetryk) {
        this.smittetryk = smittetryk;
    }
}
