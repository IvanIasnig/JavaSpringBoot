package giov.es.classes;

import java.time.LocalDate;

import giov.es.interfaces.DataSource;

public class InfoAdapter implements DataSource {
    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {

        LocalDate oggi = LocalDate.now();
        LocalDate compleanno = info.getDataDiNascita();

        int eta = oggi.getYear() - compleanno.getYear();

        if (oggi.getMonthValue() < compleanno.getMonthValue() || 
            (compleanno.getMonthValue() == compleanno.getMonthValue() && compleanno.getDayOfMonth() < compleanno.getDayOfMonth())) {
            eta--;
        }

        return eta;
    }
}





