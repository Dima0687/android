import de.eisner.affirmations.model.Affirmation
import de.eisner.affirmations.R

object DataSource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.image001),
            Affirmation(R.string.affirmation2, R.drawable.image002),
            Affirmation(R.string.affirmation3, R.drawable.image003),
            Affirmation(R.string.affirmation4, R.drawable.image004),
            Affirmation(R.string.affirmation5, R.drawable.image005),
            Affirmation(R.string.affirmation6, R.drawable.image006),
            Affirmation(R.string.affirmation7, R.drawable.image007),
            Affirmation(R.string.affirmation8, R.drawable.image008),
            Affirmation(R.string.affirmation9, R.drawable.image009),
            Affirmation(R.string.affirmation10, R.drawable.image010))
    }
}