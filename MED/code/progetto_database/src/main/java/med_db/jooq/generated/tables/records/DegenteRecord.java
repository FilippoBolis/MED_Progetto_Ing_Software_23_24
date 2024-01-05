/*
 * This file is generated by jOOQ.
 */
package med_db.jooq.generated.tables.records;


import java.time.LocalDate;
import java.time.LocalTime;

import med_db.jooq.generated.tables.Degente;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DegenteRecord extends UpdatableRecordImpl<DegenteRecord> implements Record8<String, String, String, String, LocalDate, LocalTime, Integer, Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>DEGENTE.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>DEGENTE.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DEGENTE.NOME</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DEGENTE.NOME</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DEGENTE.COGNOME</code>.
     */
    public void setCognome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DEGENTE.COGNOME</code>.
     */
    public String getCognome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DEGENTE.SESSO</code>.
     */
    public void setSesso(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>DEGENTE.SESSO</code>.
     */
    public String getSesso() {
        return (String) get(3);
    }

    /**
     * Setter for <code>DEGENTE.DATA_ARRIVO</code>.
     */
    public void setDataArrivo(LocalDate value) {
        set(4, value);
    }

    /**
     * Getter for <code>DEGENTE.DATA_ARRIVO</code>.
     */
    public LocalDate getDataArrivo() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>DEGENTE.ORA_ARRIVO</code>.
     */
    public void setOraArrivo(LocalTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>DEGENTE.ORA_ARRIVO</code>.
     */
    public LocalTime getOraArrivo() {
        return (LocalTime) get(5);
    }

    /**
     * Setter for <code>DEGENTE.URGENZA</code>.
     */
    public void setUrgenza(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>DEGENTE.URGENZA</code>.
     */
    public Integer getUrgenza() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>DEGENTE.IN_ATTESA</code>.
     */
    public void setInAttesa(Boolean value) {
        set(7, value);
    }

    /**
     * Getter for <code>DEGENTE.IN_ATTESA</code>.
     */
    public Boolean getInAttesa() {
        return (Boolean) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, String, LocalDate, LocalTime, Integer, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, String, LocalDate, LocalTime, Integer, Boolean> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Degente.DEGENTE.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Degente.DEGENTE.NOME;
    }

    @Override
    public Field<String> field3() {
        return Degente.DEGENTE.COGNOME;
    }

    @Override
    public Field<String> field4() {
        return Degente.DEGENTE.SESSO;
    }

    @Override
    public Field<LocalDate> field5() {
        return Degente.DEGENTE.DATA_ARRIVO;
    }

    @Override
    public Field<LocalTime> field6() {
        return Degente.DEGENTE.ORA_ARRIVO;
    }

    @Override
    public Field<Integer> field7() {
        return Degente.DEGENTE.URGENZA;
    }

    @Override
    public Field<Boolean> field8() {
        return Degente.DEGENTE.IN_ATTESA;
    }

    @Override
    public String component1() {
        return getCodice();
    }

    @Override
    public String component2() {
        return getNome();
    }

    @Override
    public String component3() {
        return getCognome();
    }

    @Override
    public String component4() {
        return getSesso();
    }

    @Override
    public LocalDate component5() {
        return getDataArrivo();
    }

    @Override
    public LocalTime component6() {
        return getOraArrivo();
    }

    @Override
    public Integer component7() {
        return getUrgenza();
    }

    @Override
    public Boolean component8() {
        return getInAttesa();
    }

    @Override
    public String value1() {
        return getCodice();
    }

    @Override
    public String value2() {
        return getNome();
    }

    @Override
    public String value3() {
        return getCognome();
    }

    @Override
    public String value4() {
        return getSesso();
    }

    @Override
    public LocalDate value5() {
        return getDataArrivo();
    }

    @Override
    public LocalTime value6() {
        return getOraArrivo();
    }

    @Override
    public Integer value7() {
        return getUrgenza();
    }

    @Override
    public Boolean value8() {
        return getInAttesa();
    }

    @Override
    public DegenteRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public DegenteRecord value2(String value) {
        setNome(value);
        return this;
    }

    @Override
    public DegenteRecord value3(String value) {
        setCognome(value);
        return this;
    }

    @Override
    public DegenteRecord value4(String value) {
        setSesso(value);
        return this;
    }

    @Override
    public DegenteRecord value5(LocalDate value) {
        setDataArrivo(value);
        return this;
    }

    @Override
    public DegenteRecord value6(LocalTime value) {
        setOraArrivo(value);
        return this;
    }

    @Override
    public DegenteRecord value7(Integer value) {
        setUrgenza(value);
        return this;
    }

    @Override
    public DegenteRecord value8(Boolean value) {
        setInAttesa(value);
        return this;
    }

    @Override
    public DegenteRecord values(String value1, String value2, String value3, String value4, LocalDate value5, LocalTime value6, Integer value7, Boolean value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DegenteRecord
     */
    public DegenteRecord() {
        super(Degente.DEGENTE);
    }

    /**
     * Create a detached, initialised DegenteRecord
     */
    public DegenteRecord(String codice, String nome, String cognome, String sesso, LocalDate dataArrivo, LocalTime oraArrivo, Integer urgenza, Boolean inAttesa) {
        super(Degente.DEGENTE);

        setCodice(codice);
        setNome(nome);
        setCognome(cognome);
        setSesso(sesso);
        setDataArrivo(dataArrivo);
        setOraArrivo(oraArrivo);
        setUrgenza(urgenza);
        setInAttesa(inAttesa);
        resetChangedOnNotNull();
    }
}
