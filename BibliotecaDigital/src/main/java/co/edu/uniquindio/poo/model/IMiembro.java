package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public interface IMiembro {
    public MaterialBibliografico buscarMaterialBibliografico(String id);
    public MaterialBibliografico buscarMaterialBibliograficoAutor(String autor);
    public String solicitarPrestamo(MaterialBibliografico material);
    public String devolverMaterial(MaterialBibliografico material, LocalDate fechaActual);
}
