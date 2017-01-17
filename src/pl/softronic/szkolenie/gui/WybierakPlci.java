package pl.softronic.szkolenie.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import pl.softronic.szkolenie.przyklady.serializacja.Dane.Plec;

public class WybierakPlci extends JPanel {

	private final Map<Plec, JRadioButton> przyciski = new HashMap<>();
	private final Map<JRadioButton, Plec> mapaPlci = new HashMap<>();
	
	public interface PlecChangeListener{
		void onChange(Plec jest);
	}
	private final List<PlecChangeListener> listaListenerow = new ArrayList<>();
	
	
	public WybierakPlci(){
		setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "P³eæ"
				));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ButtonGroup group = new ButtonGroup();
	    for(Plec plec : Plec.values()){
			JRadioButton b = (JRadioButton) 
					add(new JRadioButton(plec.name()));
			group.add(b);
			przyciski.put(plec, b);
			mapaPlci.put(b, plec);
			if(plec==Plec.NIE_WIEM){
				b.setSelected(true);
			}
			b.addActionListener(e->{
				Plec p = mapaPlci.get(e.getSource());
				listaListenerow.forEach(l -> l.onChange(p));
			});
		}
	}
	
	public Plec getWybranaPlec(){
		for(Map.Entry<Plec, JRadioButton> entry : przyciski.entrySet()){
			if(entry.getValue().isSelected()){
				return entry.getKey();
			}
		}
		return null;
	}

	public void setWybranaPlec(Plec plec){
		listaListenerow.forEach(l -> l.onChange(plec));
		przyciski.get(plec).setSelected(true);
	}
	
	public void addPlecChangeListener(PlecChangeListener l){
		listaListenerow.add(l);
	}
	
	public void removePlecChangeListener(PlecChangeListener l){
		listaListenerow.remove(l);
	}
	
	public void removeAllPlecChangeListener(){
		listaListenerow.clear();
	}
}
