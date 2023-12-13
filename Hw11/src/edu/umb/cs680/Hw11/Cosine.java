package edu.umb.cs680.Hw11;

import java.util.List;

public class Cosine implements DistanceMetric {
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        if (p1.size() != p2.size()) {
            throw new IllegalArgumentException("Points must have the same dimensions");
        }

        double dotProduct = 0.0;
        double normP1 = 0.0;
        double normP2 = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
            normP1 += Math.pow(p1.get(i), 2);
            normP2 += Math.pow(p2.get(i), 2);
        }

        normP1 = Math.sqrt(normP1);
        normP2 = Math.sqrt(normP2);

        if (normP1 == 0 || normP2 == 0) {
            throw new IllegalArgumentException("Norm cannot be zero");
        }

        double cosineSimilarity = dotProduct / (normP1 * normP2);
        return 1 - cosineSimilarity;
    }
}
