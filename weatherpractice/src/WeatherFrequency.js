import React from 'react'

const WeatherFrequency = (props) => {
    const { newFrequency, handleFrequencyChange, handleSubmit } = props
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="frequencyInput">Update Frequency (minutes): </label>
                    <input
                        type="number"
                        id="frequencyInput"
                        name="frequencyInput"
                        min="1"
                        value={newFrequency}
                        onChange={handleFrequencyChange}
                    />
                </div>
                <button type="submit">Update Frequency</button>
            </form>
        </div>
    )
}

export default WeatherFrequency