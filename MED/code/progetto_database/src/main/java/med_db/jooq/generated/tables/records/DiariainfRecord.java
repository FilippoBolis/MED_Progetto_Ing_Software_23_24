/*
 * This file is generated by jOOQ.
 */
package med_db.jooq.generated.tables.records;


import java.time.LocalDate;
import java.time.LocalTime;

import med_db.jooq.generated.tables.Diariainf;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DiariainfRecord extends UpdatableRecordImpl<DiariainfRecord> implements Record8<String, String, String, LocalDate, LocalTime, String, Boolean, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>DIARIAINF.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>DIARIAINF.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>DIARIAINF.CODICE_DEGENTE</code>.
     */
    public void setCodiceDegente(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>DIARIAINF.CODICE_DEGENTE</code>.
     */
    public String getCodiceDegente() {
        return (String) get(1);
    }

    /**
     * Setter for <code>DIARIAINF.CODICE_INFERMIERE</code>.
     */
    public void setCodiceInfermiere(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>DIARIAINF.CODICE_INFERMIERE</code>.
     */
    public String getCodiceInfermiere() {
        return (String) get(2);
    }

    /**
     * Setter for <code>DIARIAINF.DATA</code>.
     */
    public void setData(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>DIARIAINF.DATA</code>.
     */
    public LocalDate getData() {
        return (LocalDate) get(3);
    }

    /**
     * Setter for <code>DIARIAINF.ORA</code>.
     */
    public void setOra(LocalTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>DIARIAINF.ORA</code>.
     */
    public LocalTime getOra() {
        return (LocalTime) get(4);
    }

    /**
     * Setter for <code>DIARIAINF.NOTE_PARTICOLARI</code>.
     */
    public void setNoteParticolari(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>DIARIAINF.NOTE_PARTICOLARI</code>.
     */
    public String getNoteParticolari() {
        return (String) get(5);
    }

    /**
     * Setter for <code>DIARIAINF.IMPORTANTE</code>.
     */
    public void setImportante(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>DIARIAINF.IMPORTANTE</code>.
     */
    public Boolean getImportante() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>DIARIAINF.FARMACO</code>.
     */
    public void setFarmaco(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>DIARIAINF.FARMACO</code>.
     */
    public String getFarmaco() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, LocalDate, LocalTime, String, Boolean, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, LocalDate, LocalTime, String, Boolean, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Diariainf.DIARIAINF.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Diariainf.DIARIAINF.CODICE_DEGENTE;
    }

    @Override
    public Field<String> field3() {
        return Diariainf.DIARIAINF.CODICE_INFERMIERE;
    }

    @Override
    public Field<LocalDate> field4() {
        return Diariainf.DIARIAINF.DATA;
    }

    @Override
    public Field<LocalTime> field5() {
        return Diariainf.DIARIAINF.ORA;
    }

    @Override
    public Field<String> field6() {
        return Diariainf.DIARIAINF.NOTE_PARTICOLARI;
    }

    @Override
    public Field<Boolean> field7() {
        return Diariainf.DIARIAINF.IMPORTANTE;
    }

    @Override
    public Field<String> field8() {
        return Diariainf.DIARIAINF.FARMACO;
    }

    @Override
    public String component1() {
        return getCodice();
    }

    @Override
    public String component2() {
        return getCodiceDegente();
    }

    @Override
    public String component3() {
        return getCodiceInfermiere();
    }

    @Override
    public LocalDate component4() {
        return getData();
    }

    @Override
    public LocalTime component5() {
        return getOra();
    }

    @Override
    public String component6() {
        return getNoteParticolari();
    }

    @Override
    public Boolean component7() {
        return getImportante();
    }

    @Override
    public String component8() {
        return getFarmaco();
    }

    @Override
    public String value1() {
        return getCodice();
    }

    @Override
    public String value2() {
        return getCodiceDegente();
    }

    @Override
    public String value3() {
        return getCodiceInfermiere();
    }

    @Override
    public LocalDate value4() {
        return getData();
    }

    @Override
    public LocalTime value5() {
        return getOra();
    }

    @Override
    public String value6() {
        return getNoteParticolari();
    }

    @Override
    public Boolean value7() {
        return getImportante();
    }

    @Override
    public String value8() {
        return getFarmaco();
    }

    @Override
    public DiariainfRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public DiariainfRecord value2(String value) {
        setCodiceDegente(value);
        return this;
    }

    @Override
    public DiariainfRecord value3(String value) {
        setCodiceInfermiere(value);
        return this;
    }

    @Override
    public DiariainfRecord value4(LocalDate value) {
        setData(value);
        return this;
    }

    @Override
    public DiariainfRecord value5(LocalTime value) {
        setOra(value);
        return this;
    }

    @Override
    public DiariainfRecord value6(String value) {
        setNoteParticolari(value);
        return this;
    }

    @Override
    public DiariainfRecord value7(Boolean value) {
        setImportante(value);
        return this;
    }

    @Override
    public DiariainfRecord value8(String value) {
        setFarmaco(value);
        return this;
    }

    @Override
    public DiariainfRecord values(String value1, String value2, String value3, LocalDate value4, LocalTime value5, String value6, Boolean value7, String value8) {
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
     * Create a detached DiariainfRecord
     */
    public DiariainfRecord() {
        super(Diariainf.DIARIAINF);
    }

    /**
     * Create a detached, initialised DiariainfRecord
     */
    public DiariainfRecord(String codice, String codiceDegente, String codiceInfermiere, LocalDate data, LocalTime ora, String noteParticolari, Boolean importante, String farmaco) {
        super(Diariainf.DIARIAINF);

        setCodice(codice);
        setCodiceDegente(codiceDegente);
        setCodiceInfermiere(codiceInfermiere);
        setData(data);
        setOra(ora);
        setNoteParticolari(noteParticolari);
        setImportante(importante);
        setFarmaco(farmaco);
        resetChangedOnNotNull();
    }
}