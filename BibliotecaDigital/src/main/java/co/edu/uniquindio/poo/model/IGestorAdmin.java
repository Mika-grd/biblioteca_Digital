package co.edu.uniquindio.poo.model;

public interface IGestorAdmin {
    String agregarMaterial(MaterialBibliografico material);
    String eliminarMaterial(MaterialBibliografico material);
    String editarMaterial(MaterialBibliografico material, MaterialBibliografico materialNuevo);
    MaterialBibliografico buscarMaterial(String id);
}
