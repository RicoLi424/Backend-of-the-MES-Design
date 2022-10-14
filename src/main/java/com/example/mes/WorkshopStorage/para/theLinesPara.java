package com.example.mes.WorkshopStorage.para;

import java.util.List;

public class theLinesPara {
        private List<LinePara> lines;
        private int lineNum;
        private String theWorkshopId;
        private String company_id;

        public String getCompany_id() {
                return company_id;
        }

        public void setCompany_id(String company_id) {
                this.company_id = company_id;
        }

        public List<LinePara> getLines() {
                return lines;
        }

        public void setLines(List<LinePara> lines) {
                this.lines = lines;
        }

        public int getLineNum() {
                return lineNum;
        }

        public void setLineNum(int lineNum) {
                this.lineNum = lineNum;
        }

        public String getTheWorkshopId() {
                return theWorkshopId;
        }

        public void setTheWorkshopId(String theWorkshopId) {
                this.theWorkshopId = theWorkshopId;
        }
}
