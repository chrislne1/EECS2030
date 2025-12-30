package model;

public class Subscriber extends Follower {

	public Subscriber(String name, int maxchannels, int maxvideos) {
		super.setName(name);
		super.setMaxchannels(maxchannels);
		super.setMaxvideos(maxvideos);
		super.setTypeOfFollower("Subscriber");
		//"Subscriber Alan follows no channels and has no recommended videos."
	}

	public String toString() {
		String str = "Subscriber " + super.getName() + " follows ";

		if (super.getNumofchannels() == 0) {
			str += "no channels";
		}

		else {
			str += "[";
			for(int i =0; i < super.getChannels().length; i++) {
				if (super.getChannels()[i] != null) {
					str += super.getChannels()[i].getName();

					if(super.getChannels()[i+1] != null) {
						str += ", ";
					}
				}
			}
			str += "]";
		}

		str += " and ";

		//Subscriber Alan follows [Cafe Music BGM] and has no recommended videos.

		if (super.getNumofvideos() == 0) {
			str += "has no recommended videos.";
		}

		else {
			//Subscriber Alan follows [Cafe Music BGM, I Love You Venice] and is recommended <Jazz Piano Radio>.
			str += "is recommended <";

			for(int i =0; i< super.getNewVideos().length; i++) {
				if (super.getNewVideos()[i] != null) {
					str += super.getNewVideos()[i];

					if (i <  super.getNewVideos().length -1 && super.getNewVideos()[i+1] != null) {
						str+= ", ";
					}
				}
			}

			str += ">.";
		}

		return str;
	}

	public void watch(String video, int mins) {

		// update subscriber stats first
		super.updateVideo(video, mins);

		Channel target = null;

		// find which channel the video belongs to
		for (int i = 0; i < super.getChannels().length; i++) {
			if (super.getChannels()[i] != null) {

				for (int j = 0; j < super.getChannels()[i].getBgm().length; j++) {
					if (super.getChannels()[i].getBgm()[j] != null &&
							super.getChannels()[i].getBgm()[j].equals(video)) {

						target = super.getChannels()[i];
						break;
					}
				}
			}
			if (target != null) {
				break;
			}
		}

		// update all monitors of that channel
		if (target != null) {
			for (int i = 0; i < target.getFollowers().length; i++) {
				if (target.getFollowers()[i] != null &&
						target.getFollowers()[i].getTypeOfFollower().equals("Monitor")) {

					target.getFollowers()[i].updateVideo(video, mins);
				}
			}
		}


	}
}
