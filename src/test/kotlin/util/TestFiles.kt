package util

import org.assertj.core.api.Assertions.*
import java.io.File
import java.nio.file.*

fun getResourcePath(relativePath: String): Path {
    val url = TestCmdRunner::class.java.classLoader.getResource(relativePath)
    return Paths.get(url.toURI())
}

fun create(directory: File): File? {
    if (directory.mkdir()) return directory
    return null
}

fun assertOutputMatches(filename: String) =
    assertThat(testOutputDir.resolve(filename)).hasSameContentAs(testOutputResourcesDir.resolve(filename))!!

// Resource Directories
val testInputResourcesDir = getResourcePath("test-input-files")
val testOutputResourcesDir = getResourcePath("test-output-files")

// Test Working Directories
val testDir = createTempDir()
val testInputDir = testDir.resolve("input").toPath()!!
val testOutputDir = create(testDir.resolve("output"))!!.toPath()!!

/*
 * Input Files
 */
val PEAKS = testInputDir.resolve("ENCFF165UME.chr19.bed")!!
val SHUFFLED_PEAKS = testInputDir.resolve("ENCFF165UME.chr19.shuffled.bed")!!
val CHR22_TWO_BIT= testInputDir.resolve("hg38.chr22.2bit")!!
val CHR22_CHROM_INFO = testInputDir.resolve("hg38.chr22.chrom.sizes")!!
val CHR19_TWO_BIT= testInputDir.resolve("hg38.chr19.2bit")!!
val CHR19_CHROM_INFO = testInputDir.resolve("hg38.chr19.chrom.sizes")!!

val METHYL_BED = testInputDir.resolve("ENCFF550FZT.chr19.methyl.bed.gz")!!
// Peaks file used for single-methyl-bed run
val M_PEAKS = testInputDir.resolve("ENCFF981HPG.bed")!!

val METHYL_BED_2A = testInputDir.resolve("ENCFF696OLO.chr22.methyl.bed.gz")!!
val METHYL_BED_2B = testInputDir.resolve("ENCFF804NTQ.chr22.methyl.bed.gz")!!
// Peaks file used for two-methyl-beds run
val M2_PEAKS = testInputDir.resolve("ENCFF360CQR.chr22.bed.gz")!!

/*
 * Input Files for tomtom test
 */
val MOTIF_MEME_XML = testInputDir.resolve("ENCFF002CHV.meme.xml")!!
val COMPARISON_DB1 = testInputDir.resolve("HOCOMOCO.human.txt")!!
val COMPARISON_DB2 = testInputDir.resolve("HOCOMOCO.mouse.txt")!!
val COMPARISON_DB3 = testInputDir.resolve("JASPAR.txt")!!



/*
 * Output File Names
 */
const val PREFIX = "ENCFF165UME"
const val SHUFFLED_PEAKS_FILENAME = "$PREFIX.chr19.shuffled.bed"
const val CLEANED_PEAKS = "$PREFIX$CLEANED_BED_SUFFIX"
const val SUMMITS = "$PREFIX$SUMMITS_FILE_SUFFIX"
const val BASE_SEQS = "$PREFIX$SEQS_SUFFIX"
const val FIMO_DIR = "$PREFIX$FIMO_SUFFIX"
const val FIMO_TSV = "$FIMO_DIR/$FIMO_TSV_FILENAME"
const val OCCURRENCES_TSV = "$PREFIX$OCCURRENCES_SUFFIX"
const val TOP500_SEQS = "$PREFIX$TOP500_SEQS_SUFFIX"
const val TOP500_SEQS_CENTER = "$PREFIX$TOP500_SEQS_CENTER_SUFFIX"
const val MEME_DIR = "$PREFIX$MEME_DIR_SUFFIX"
const val TOP500_MEME_TXT = "$MEME_DIR/$MEME_TXT_FILENAME"
const val TOP500_MEME_XML = "$MEME_DIR/$MEME_XML_FILENAME"
const val TOP501_1000_SEQS = "$PREFIX$NEXT500_SEQS_SUFFIX"
const val TOP501_1000_SEQS_CENTER = "$PREFIX$NEXT500_SEQS_CENTER_SUFFIX"
const val TOP501_1000_SEQS_FLANK = "$PREFIX$NEXT500_SEQS_FLANK_SUFFIX"
const val TOP501_1000_CENTER_FIMO_DIR = "$PREFIX$CENTER_FIMO_DIR_SUFFIX"
const val TOP501_1000_CENTER_FIMO_TSV = "$TOP501_1000_CENTER_FIMO_DIR/$FIMO_TSV_FILENAME"
const val TOP501_1000_CENTER_FIMO_XML = "$TOP501_1000_CENTER_FIMO_DIR/$FIMO_XML_FILENAME"
const val TOP501_1000_FLANK_FIMO_DIR = "$PREFIX$FLANK_FIMO_DIR_SUFFIX"
const val TOP501_1000_FLANK_FIMO_TSV = "$TOP501_1000_FLANK_FIMO_DIR/$FIMO_TSV_FILENAME"
const val TOP501_1000_SHUFFLED_SEQS = "$PREFIX$SHUFFLED_SEQS_SUFFIX"
const val TOP501_1000_SHUFFLED_FIMO_DIR = "$PREFIX$SHUFFLED_FIMO_DIR_SUFFIX"
const val TOP501_1000_SHUFFLED_FIMO_TSV = "$TOP501_1000_SHUFFLED_FIMO_DIR/$FIMO_TSV_FILENAME"
const val MOTIFS_JSON = "$PREFIX$MOTIFS_JSON_SUFFIX"
const val EXTRA_FIMO_DIR = "$PREFIX$EXTRA_FIMO_SUFFIX"
const val EXTRA_OCCURRENCES_TSV = "$EXTRA_FIMO_DIR/$PREFIX.$SHUFFLED_PEAKS_FILENAME$OCCURRENCES_SUFFIX"

// Outputs for methyl run
const val M_PREFIX = "ENCFF981HPG"
const val M_CLEANED_PEAKS = "$M_PREFIX$CLEANED_BED_SUFFIX"
const val M_SUMMITS = "$M_PREFIX$SUMMITS_FILE_SUFFIX"
const val M_BASE_SEQS = "$M_PREFIX$SEQS_SUFFIX"
const val M_OCCURRENCES_TSV = "$M_PREFIX$OCCURRENCES_SUFFIX"
const val M_TOP500_SEQS = "$M_PREFIX$TOP500_SEQS_SUFFIX"
const val M_TOP500_SEQS_CENTER = "$M_PREFIX$TOP500_SEQS_CENTER_SUFFIX"
const val M_MEME_DIR = "$M_PREFIX$MEME_DIR_SUFFIX"
const val M_TOP500_MEME_TXT = "$M_MEME_DIR/$MEME_TXT_FILENAME"
const val M_TOP500_MEME_XML = "$M_MEME_DIR/$MEME_XML_FILENAME"
const val M_TOP501_1000_SEQS = "$M_PREFIX$NEXT500_SEQS_SUFFIX"
const val M_TOP501_1000_SEQS_CENTER = "$M_PREFIX$NEXT500_SEQS_CENTER_SUFFIX"
const val M_TOP501_1000_SEQS_FLANK = "$M_PREFIX$NEXT500_SEQS_FLANK_SUFFIX"
const val M_FIMO_DIR = "$M_PREFIX$FIMO_SUFFIX"
const val M_FIMO_TSV = "$M_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M_TOP501_1000_CENTER_FIMO_DIR = "$M_PREFIX$CENTER_FIMO_DIR_SUFFIX"
const val M_TOP501_1000_CENTER_FIMO_TSV = "$M_TOP501_1000_CENTER_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M_TOP501_1000_FLANK_FIMO_DIR = "$M_PREFIX$FLANK_FIMO_DIR_SUFFIX"
const val M_TOP501_1000_FLANK_FIMO_TSV = "$M_TOP501_1000_FLANK_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M_TOP501_1000_SHUFFLED_SEQS = "$M_PREFIX$SHUFFLED_SEQS_SUFFIX"
const val M_TOP501_1000_SHUFFLED_FIMO_DIR = "$M_PREFIX$SHUFFLED_FIMO_DIR_SUFFIX"
const val M_TOP501_1000_SHUFFLED_FIMO_TSV = "$M_TOP501_1000_SHUFFLED_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M_MOTIFS_JSON = "$M_PREFIX$MOTIFS_JSON_SUFFIX"

// Outputs for 2 methyl bed run
const val M2_PREFIX = "ENCFF360CQR"
const val M2_CLEANED_PEAKS = "$M2_PREFIX$CLEANED_BED_SUFFIX"
const val M2_SUMMITS = "$M2_PREFIX$SUMMITS_FILE_SUFFIX"
const val M2_BASE_SEQS = "$M2_PREFIX$SEQS_SUFFIX"
const val M2_OCCURRENCES_TSV = "$M2_PREFIX$OCCURRENCES_SUFFIX"
const val M2_TOP500_SEQS = "$M2_PREFIX$TOP500_SEQS_SUFFIX"
const val M2_TOP500_SEQS_CENTER = "$M2_PREFIX$TOP500_SEQS_CENTER_SUFFIX"
const val M2_MEME_DIR = "$M2_PREFIX$MEME_DIR_SUFFIX"
const val M2_TOP500_MEME_TXT = "$M2_MEME_DIR/$MEME_TXT_FILENAME"
const val M2_TOP500_MEME_XML = "$M2_MEME_DIR/$MEME_XML_FILENAME"
const val M2_TOP501_1000_SEQS = "$M2_PREFIX$NEXT500_SEQS_SUFFIX"
const val M2_TOP501_1000_SEQS_CENTER = "$M2_PREFIX$NEXT500_SEQS_CENTER_SUFFIX"
const val M2_TOP501_1000_SEQS_FLANK = "$M2_PREFIX$NEXT500_SEQS_FLANK_SUFFIX"
const val M2_TOP501_1000_CENTER_FIMO_DIR = "$M2_PREFIX$CENTER_FIMO_DIR_SUFFIX"
const val M2_TOP501_1000_CENTER_FIMO_TSV = "$M2_TOP501_1000_CENTER_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M2_TOP501_1000_FLANK_FIMO_DIR = "$M2_PREFIX$FLANK_FIMO_DIR_SUFFIX"
const val M2_TOP501_1000_FLANK_FIMO_TSV = "$M2_TOP501_1000_FLANK_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M2_TOP501_1000_SHUFFLED_SEQS = "$M2_PREFIX$SHUFFLED_SEQS_SUFFIX"
const val M2_TOP501_1000_SHUFFLED_FIMO_DIR = "$M2_PREFIX$SHUFFLED_FIMO_DIR_SUFFIX"
const val M2_TOP501_1000_SHUFFLED_FIMO_TSV = "$M2_TOP501_1000_SHUFFLED_FIMO_DIR/$FIMO_TSV_FILENAME"
const val M2_MOTIFS_JSON = "$M2_PREFIX$MOTIFS_JSON_SUFFIX"


// Output for tomtom test
const val TOMTOM_TSV = "ENCFF002CHV.tomtom.tsv"
const val TOMTOM_XML = "ENCFF002CHV.tomtom.xml"

 