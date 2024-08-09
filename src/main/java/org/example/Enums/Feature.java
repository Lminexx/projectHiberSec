package org.example.Enums;

public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes"),
    ;

    private final String value;

    Feature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Feature getFeatureByValue(String value) {
        for (Feature feature : Feature.values()) {
            if (feature.getValue().equals(value)) {
                return feature;
            }
        }
        return null;
    }
}
