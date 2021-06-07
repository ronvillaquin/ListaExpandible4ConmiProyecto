package com.example.listaexpandible4conmiproyecto;

class GrupoPadre {
    // Clase para modelar el Padre.


        // Variables gasto.
        private final int imgPadre;
        private final String nombrePadre;
        private final float montoPadre;

        // Constructores.
        public GrupoPadre(int imgPadre, String nombrePadre, float montoPadre) {
            this.imgPadre = imgPadre;
            this.nombrePadre = nombrePadre;
            this.montoPadre = montoPadre;
        }

        // RETORNAMOS los valores.
        public int getimgPadre() {
            return imgPadre;
        }

        public String getnombrePadre() {
            return nombrePadre;
        }

        public float getmontoPadre() {
            return montoPadre;
        }


}
