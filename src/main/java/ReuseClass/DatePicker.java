package ReuseClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



public class DatePicker extends JDatePickerImpl {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public DatePicker() {
		super(new JDatePanelImpl(new UtilDateModel(), getProperties()), new AbstractFormatter() {
			@Override
			public Object stringToValue(String text) throws ParseException {
				String res = text.replaceAll("/", "-");
				return res;
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null) {
					Calendar calendar = (Calendar) value;
					Date date = calendar.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					return sdf.format(date);
				}
				return null;
			}
		});
		this.setMinimumSize(new java.awt.Dimension(150, 30));
	}

	private static Properties getProperties() {
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		return p;
	}

	public String getDateString() {
		Date selectedDate = (Date) getModel().getValue();
		return sdf.format(selectedDate);
	}

	public void setDate(LocalDate date) {
		getModel().setDate(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
		getModel().setSelected(true);
	}

	public void setEditable(boolean b) {
		getJFormattedTextField().setEditable(b);
	    getComponent(1).setEnabled(b); // Disable/enable the date picker button

	}
}
