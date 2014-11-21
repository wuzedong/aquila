package com.highgo.hgdbadmin.myutil;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jline.ConsoleReader;

import com.highgo.hgdbadmin.model.ConstraintCK;
import com.highgo.hgdbadmin.model.ConstraintFK;
import com.highgo.hgdbadmin.model.ConstraintPK;
import com.highgo.hgdbadmin.model.ConstraintUK;
import com.highgo.hgdbadmin.model.Function;
import com.highgo.hgdbadmin.model.Index;
import com.highgo.hgdbadmin.model.Procedure;
import com.highgo.hgdbadmin.model.Schema;
import com.highgo.hgdbadmin.model.Sequence;
import com.highgo.hgdbadmin.model.Table;
import com.highgo.hgdbadmin.model.Trigger;
import com.highgo.hgdbadmin.model.View;

public class Test2 {
	
	public static class Constants{

		public static final List<Schema> SCHEMAS = new LinkedList<>();
		public static final List<Table> TABLES = new LinkedList<>();
		public static final List<Sequence> SEQUENCES = new LinkedList<>();
		public static final List<View> VIEWS = new LinkedList<>();
		public static final List<Index> INDEXES = new LinkedList<>();
		public static final List<Procedure> PROCEDURES = new LinkedList<>();
		public static final List<Function> FUNCTIONS = new LinkedList<>();
		public static final List<Trigger> TRIGGERS = new LinkedList<>();
		
		public static final List<ConstraintCK> CKS = new LinkedList<>();
		public static final List<ConstraintPK> PKS = new LinkedList<>();
		public static final List<ConstraintUK> UKS = new LinkedList<>();
		public static final List<ConstraintFK> FKS = new LinkedList<>();
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		ConsoleReader reader = new ConsoleReader();
		reader.printString("they are all object in source database below��");
		reader.printNewline();
		reader.printString("str");

		// //list schema
		reader.printString("schemas:");
		List<Schema> schemas = MigrateCenter.fetchSchemasFromSqlServer();
		Constants.SCHEMAS.clear();
		Object[] schemass = schemas.toArray();
		for (int i = 0; i < schemas.size(); i++) {
			Constants.SCHEMAS.add((Schema) schemass[i]);
			String strt = ((Schema) schemass[i]).name + "[" + i + "]		";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list table
		reader.printString("tables:");
		List<Table> tables = MigrateCenter.fetchTableFromSqlServer();
		Constants.TABLES.clear();
		Constants.TABLES.addAll(tables);
		for (int i = 0; i < tables.size(); i++) {
			String strt = tables.get(i).schema + "." + tables.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list sequences
		reader.printString("sequences:");
		List<Sequence> sequences = MigrateCenter.fetchSequencesFromSqlServer();
		Constants.SEQUENCES.clear();
		Constants.SEQUENCES.addAll(sequences);
		for (int i = 0; i < sequences.size(); i++) {
			String strt = sequences.get(i).schema + "." + sequences.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list views
		reader.printString("views:");
		List<View> views = MigrateCenter.fetchViewsFromSqlServer();
		Constants.VIEWS.clear();
		Constants.VIEWS.addAll(views);
		for (int i = 0; i < views.size(); i++) {
			String strt = views.get(i).schema + "." + views.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();
		// list index
		reader.printString("indexes:");
		List<Index> indexes = MigrateCenter.fetchIndexesFromSqlServer();
		Constants.INDEXES.clear();
		Constants.INDEXES.addAll(indexes);
		for (int i = 0; i < indexes.size(); i++) {
			String strt = indexes.get(i).schema + "." + indexes.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list procedure
		reader.printString("procedures:");
		List<Procedure> procedures = MigrateCenter.fetchProceduresFromSqlServer();
		Constants.PROCEDURES.clear();
		Constants.PROCEDURES.addAll(procedures);
		for (int i = 0; i < procedures.size(); i++) {
			String strt = procedures.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list function
		reader.printString("functions:");
		List<Function> functions = MigrateCenter.fetchFunctionsFromSqlServer();
		Constants.FUNCTIONS.clear();
		Constants.FUNCTIONS.addAll(functions);
		for (int i = 0; i < functions.size(); i++) {
			String strt = functions.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list Trigger
		reader.printString("Triggers:");
		List<Trigger> triggers = MigrateCenter.fetchTriggerFromSqlServer();
		Constants.TRIGGERS.clear();
		Constants.TRIGGERS.addAll(triggers);
		for (int i = 0; i < triggers.size(); i++) {
			String strt = triggers.get(i).name + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list check constraint
		reader.printString("Check Constraint:");
		List<ConstraintCK> cks = MigrateConstraint.fetchConstraintCKFromSqlServer();
		Constants.CKS.clear();
		Constants.CKS.addAll(cks);
		for (int i = 0; i < cks.size(); i++) {
			String strt = cks.get(i).cName + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list primary key
		reader.printString("Primary key Constraint:");
		List<ConstraintPK> pks = MigrateConstraint.fetchConstraintPKFromSqlServer();
		Constants.PKS.clear();
		Constants.PKS.addAll(pks);
		for (int i = 0; i < pks.size(); i++) {
			String strt = pks.get(i).cName + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list unique key
		reader.printString("Unique key Constraint:");
		List<ConstraintUK> uks = MigrateConstraint.fetchConstraintUKFromSqlServer();
		Constants.UKS.clear();
		Constants.UKS.addAll(uks);
		for (int i = 0; i < uks.size(); i++) {
			String strt = uks.get(i).cName + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		// list foreign key
		reader.printString("Foreign Key Constraint:");
		List<ConstraintFK> fks = MigrateConstraint.fetchConstraintFKFromSqlServer();
		Constants.FKS.clear();
		Constants.FKS.addAll(fks);
		for (int i = 0; i < fks.size(); i++) {
			String strt = fks.get(i).cName + "[" + i + "]	";
			if (i % 2 == 0) {
				reader.printNewline();
			}
			reader.printString(strt);
		}
		reader.printNewline();

		reader.printNewline();
		reader.flushConsole();
	}
}
