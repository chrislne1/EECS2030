package model;

public class Monitor extends Follower {

	public Monitor(String name, int maxchannels) {
		super.setName(name);
		super.setMaxchannels(maxchannels);
		super.setTypeOfFollower("Monitor");
	}
	
	public String toString() {
		//"Monitor Stat Sensor A follows no channels."
		//Monitor Stat Sensor A follows [Cafe Music BGM {#views: 2, max watch time: 30, avg watch time: 25.00}, I Love You Venice]
				String str = "Monitor " + super.getName() + " follows ";

				if (super.getNumofchannels() == 0) {
					str += "no channels";
				}
				else {
					str += "[";
					for(int i =0; i < super.getChannels().length; i++) {
						if (super.getChannels()[i] != null) {
							str += super.getChannels()[i].getName();

							if (super.getCh_views()[i] != 0) {
							    String avg = String.format("%.2f", super.getCh_avgmins()[i]);
							    str += " {#views: " + super.getCh_views()[i] +
							           ", max watch time: " + super.getCh_maxmins()[i] +
							           ", avg watch time: " + avg + "}";
							}

							
							
							if(super.getChannels()[i+1] != null) {
								str += ", ";
							}
						}
					}
					str += "]";
				}

				str += ".";

				return (str);
	}
}
